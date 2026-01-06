#🚗 Araç Kiralama Sistemi (Java)

Bu proje, nesne yönelimli programlama (OOP) prensipleri kullanılarak geliştirilmiş console tabanlı bir araç kiralama sistemidir.
Proje, Java dili ile yazılmış olup eğitim amaçlıdır.

⚠️ Not:
Repository açıldığında main branch üzerinde yalnızca bu README bulunmaktadır.
Tüm kaynak kodlar master branch’inde yer almaktadır.

##📌 Projenin Amacı

Bu projenin amacı:

OOP kavramlarını (Inheritance, Polymorphism, Encapsulation, Interface) uygulamak

Gerçek hayata yakın bir araç kiralama senaryosu modellemek

Katmanlı ve düzenli bir proje yapısı oluşturmaktır

##🧩 Kullanılan Teknolojiler

Java 21

Console tabanlı kullanıcı arayüzü

JUnit (unit testler için)

JavaDoc (dokümantasyon için)

##🏗️ Proje Yapısı
src/
 ├─ models/
 │   ├─ Car
 │   ├─ ElectricCar
 │   ├─ GasCar
 │   ├─ Customer
 │   ├─ RentalRecord
 │   ├─ Payment
 │   ├─ PaymentMethod
 │   ├─ Transmission
 │   └─ Rentable
 │
 ├─ services/
 │   ├─ CarInventory
 │   └─ RentalService
 │
 └─ Main.java

##🚘 Sistem Özellikleri

Elektrikli ve benzinli araçlar

Manuel / otomatik vites ayrımı

Araç müsaitlik kontrolü

Araç kiralama ve iade işlemleri

Kiralama geçmişi takibi

Ödeme yöntemleri:

Kredi Kartı

Havale (IBAN bilgisi)

Nakit

Kredi kartı için kart bilgisi doğrulama

JavaDoc ile dokümantasyon

##▶️ Programın Çalışma Mantığı

Kullanıcı konsol üzerinden:

Müsait araçları listeler

Araç kiralar

Araç iade eder

Kiralama geçmişini görüntüler

Tüm işlemler RentalService ve CarInventory sınıfları üzerinden yönetilir.

##🧪 Testler

Temel işlevler için JUnit testleri yazılmıştır

Kiralama, iade ve ödeme senaryoları test edilmiştir

##📚 Dokümantasyon

Projedeki tüm sınıflar ve metotlar JavaDoc ile açıklanmıştır

javadoc komutu ile /doc klasörü oluşturulabilir

##📌 Branch Bilgisi

main → README (tanıtım amaçlı)

master → Tüm proje kaynak kodları

##👤 Geliştirici

Öğrenci Projesi

Eğitim ve öğrenme amaçlı geliştirilmiştir
