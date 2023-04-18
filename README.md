## PATİKA.DEV & LOGO JAVA-SPRING BOOT BOOTCAMP BITIRME PROJESİ

Online uçak ve otobüs bilet satış uygulaması ve ylculuk seferlerinin sisteme girilmesi için gerekli API'lerin yazılması.

### KULLANILAN TEKNOLOJİLER

- Java 8
- RESTful
- Spring Boot
- PostgreSQL
- RabbitMQ
- Postman
- Docker
- Intellij IDEA

### SERVİSLER

#### Booking-user-service

**User**

* Kullanıcı sisteme kayıt ve login olabilir.
* Kullanıcı kaydı sırasında email kontrolü yapılır.
* Kullanıcı isim ve şifresini değiştirebilir.
* Bütün kullanıcılar sorgulanabilir.
* Kullanıcı kayıt olurken Bireysel ve Kurumsal olarak usertype seçilebilir.
* Şifre hashing algoritması ile kaydedilir.

**Ticket**

* Kullanıcı id'si ile o kullanıcıya ait biletler sorgulanabilir.

**Booking**

* Kullanıcıdan alınan yolcu listesi, admin tarafından eklenen seferin id'si ve kullanıcı id'si kullanılarak yeni bilet alma işlemi yapılır.
* Bireysel kullanıcı aynı sefer için en fazla 5 bilet alabilir.
* Bireysel kullanıcı tek bir siparişte en fazla 2 erkek yolcu için bilet alabilir.
* Kurumsal kullanıcı aynı sefer için en fazla 20 bilet alabilir.
* Kullanıcı userId ile aldığı bütün biletleri sorgulayabilir.
* Yolcu sayısına göre seferin kapasitesi yeniden düzenlenir.
* Her bilet alma işleminde yolcu sayısına göre toplam ücret hesaplanır ve database'e kaydedilir.

#### Booking-api

**Admin**

* Admin sisteme kayıt ve login olabilir.
* Admin kaydı sırasında email kontrolü yapılır.
* Admin isim ve şifresini değiştirebilir.
* Bütün adminler sorgulanabilir.
* Şifre hashing algoritması ile kaydedilir.

**Voyage**

* Yeni sefer eklenebilir, iptal edilebilir.
* Şehir ve tarih bilgisi ile sefer sorgulanabilir.
* Uçak ve otobüs kapasitesi sefer oluştururken ayarlanabilir. (Otobüs 45, uçak 189 olarak ayarlanması beklenmektedir. Yeni seferler oluşturulurken bu değerler kullanılabilir.)
* Bütün seferler sorgulanabilir.
* Sefer id'si ile sefer sorgulanabilir.
* Seferlere ücret bilgisi eklenir.
* Şehirler ve taşıt türü enum olarak eklenmiştir.

#### Booking-payment

* İşlemleri senkron olarak gerçekleştirmek için feign kullanılmıştır.
* Bilet satın alma işlemi payment servisi ile yapılır.
* Ödeme yöntemi olarak kredi kartı eklenmiştir.

#### Booking-mail-service

* RabbitMQ kullanılarak mesaj ve mail işlemleri asenkron olarak gerçekleşir.
* Kullanıcı kaydı tamamlandığında kullanıcının email'ine mail atma işlemi yapılır. Mail bilgileri database'e kaydedilir.
* Bilet satın alma işlemi tamamlandığında bilgiler kullanıcının telefon numarasına gönderilir. Mesaj bilgileri database'e kaydedilir.

### POSTMAN

Postman collection projeye eklenmiştir. Postmane import edilip request yapılabilir.

#### Booking-user-service

**User**

* Yeni kullanıcı kaydı
- POST http://localhost:3436/users/register

![adduser](https://user-images.githubusercontent.com/72973798/183329096-17df83d5-5f49-4453-8eb5-8867bbe33bc1.png)

* Kullanıcı login işlemi
- GET http://localhost:3436/users/login

![userlogin](https://user-images.githubusercontent.com/72973798/183329162-563724cb-2b11-4013-87c8-5edb37796dfc.png)

* Kullanıcı id ile isim ve şifre güncelleme işlemi
- PUT http://localhost:3436/users/userId

![user-changename](https://user-images.githubusercontent.com/72973798/183329199-3e28792e-f3b7-4de3-ac3d-b65cdfb01047.png)

* Bütün kullanıcıları sorgulama işlemi
- GET http://localhost:3436/users

**Ticket**

* Kullanıcı id ile bilet sorgulama işlemi
- GET http://localhost:3436/ticket/userId

**Booking**

* Bilet satın alma işlemi
- http://localhost:3436/booking/voyageId/userId/username

![booking](https://user-images.githubusercontent.com/72973798/183329242-09d1c60e-9149-4096-9cfa-a8b2418b499f.png)


#### Booking-api

**Admin**

* Yeni admin kaydı
- POST http://localhost:3435/admins/signup

![adminsignup](https://user-images.githubusercontent.com/72973798/183329311-6a583171-a446-445f-b0f6-05d778d9af7c.png)

* Admin login işlemi
- GET http://localhost:3435/admins/login

![adminlogin](https://user-images.githubusercontent.com/72973798/183329333-27a6de49-bad6-4ea1-b749-9837e4246cb0.png)

* Admin id ile isim ve şifre güncelleme işlemi
- PUT http://localhost:3435/admins/adminId

![adminuptade](https://user-images.githubusercontent.com/72973798/183329346-f93cecf3-e4c9-48f4-ba87-c152cdde9d73.png)

* Bütün adminleri sorgulama işlemi
- GET http://localhost:3435/admins
* Admin id ile admin sorgulama
- GET http://localhost:3435/admins/adminId
- 
**Voyage**

* Sefer ekleme işlemi
- POST http://localhost:3435/voyage/addVoyage

![addvoyage](https://user-images.githubusercontent.com/72973798/183329386-bda0b067-b216-4fdf-9b26-ab2bf74e59a7.png)

* Bütün seferleri sorgulama
- GET http://localhost:3435/voyage/allVoyage
* id ile sefer sorgulama işlemi
- GET http://localhost:3435/voyage/{id}
* Şehir ve tarih bilgisi için sefer sorgulama
- GET http://localhost:3435/voyage/{sourceCity}/{destinationCity}/{voyageDate}

![voyage-search](https://user-images.githubusercontent.com/72973798/183329431-cbc8231a-1e55-4271-ae8b-2387a419a2aa.png)

* Seferin yolcu kapasitesini güncelleme
- PUT http://localhost:3435/voyage/{voyageId}/{noOfSeats}

![voyage-noseat](https://user-images.githubusercontent.com/72973798/183329445-8975cb79-9f8c-4ced-8988-411eff62d932.png)

* id ile sefer iptal etme işlemi 
- DELETE http://localhost:3435/voyage/deleteVoyage/{id}

