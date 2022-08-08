## PATİKA.DEV & LOGO JAVA-SPRING BOOT BOOTCAMP BITIRME PROJESİ

Online uçak ve otobüs bilet satış uygulaması ve ylculuk seferlerinin sisteme girilmesi için gerekli API'lerin yazılması.

### KULLANILAN TEKNOLOJİLER

- Java 8
- RESTful
- Spring Boot
- PostgreSQL
- RabbitMQ
- JUnit
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
* Kullanıcı login işlemi
- GET http://localhost:3436/users/login
* Kullanıcı id ile isim ve şifre güncelleme işlemi
- PUT http://localhost:3436/users/userId
* Bütün kullanıcıları sorgulama işlemi
- GET http://localhost:3436/users

**Ticket**

* Kullanıcı id ile bilet sorgulama işlemi
- GET http://localhost:3436/ticket/userId

**Booking**

* Bilet satın alma işlemi
- http://localhost:3436/booking/voyageId/userId/username

#### Booking-api

**Admin**

* Yeni admin kaydı
- POST http://localhost:3435/admins/signup
* Admin login işlemi
- GET http://localhost:3435/admins/login
* Admin id ile isim ve şifre güncelleme işlemi
- PUT http://localhost:3435/admins/adminId
* Bütün adminleri sorgulama işlemi
- GET http://localhost:3435/admins
* Admin id ile admin sorgulama
- GET http://localhost:3435/admins/adminId
- 
**Voyage**

* Sefer ekleme işlemi
- POST http://localhost:3435/voyage/addVoyage
* Bütün seferleri sorgulama
- GET http://localhost:3435/voyage/allVoyage
* id ile sefer sorgulama işlemi
- GET http://localhost:3435/voyage/{id}
* Şehir ve tarih bilgisi için sefer sorgulama
- GET http://localhost:3435/voyage/{sourceCity}/{destinationCity}/{voyageDate}
* Seferin yolcu kapasitesini güncelleme
- PUT http://localhost:3435/voyage/{voyageId}/{noOfSeats}
* id ile sefer iptal etme işlemi 
- DELETE http://localhost:3435/voyage/deleteVoyage/{id}

