# 🚗 Araç Kiralama Sistemi (Java)

Bu proje, Java dili kullanılarak geliştirilmiş **console tabanlı bir araç kiralama sistemidir**.  
Proje, **Nesne Yönelimli Programlama (OOP)** prensiplerine uygun olarak tasarlanmıştır ve araç kiralama–iade süreçlerini yönetir.

---

## 📌 Proje Özellikleri

- Elektrikli ve benzinli araç desteği
- Araç ekleme ve çıkarma
- Müsait araçları listeleme
- Araç kiralama ve iade işlemleri
- Kiralama geçmişi takibi
- Ödeme sistemi (Kredi Kartı, Havale, Nakit)
- JUnit 5 ile birim testler
- JavaDoc dokümantasyonu

---

## 🧱 Kullanılan OOP Kavramları

- **Kalıtım (Inheritance)**  
  `Car` → `ElectricCar`, `GasCar`

- **Polimorfizm (Polymorphism)**  
  `calculateRentalFee()` metodu override edilmiştir.

- **Arayüz (Interface)**  
  `Rentable` arayüzü ile kiralanabilir nesneler tanımlanmıştır.

- **Kapsülleme (Encapsulation)**  
  Sınıf alanları private/protected olarak tanımlanmıştır.

---

## 🗂️ Proje Paket Yapısı
src
├── interfaces
│ └── Rentable.java
│
├── models
│ ├── Vehicle.java
│ ├── Car.java
│ ├── ElectricCar.java
│ ├── GasCar.java
│ ├── Customer.java
│ ├── RentalRecord.java
│ ├── Payment.java
│ ├── PaymentMethod.java
│ └── Transmission.java
│
├── services
│ ├── CarInventory.java
│ └── RentalService.java
│
└── Main.java

## 💳 Ödeme Sistemi

Desteklenen ödeme yöntemleri:

- **Kredi Kartı**  
  Kart sahibi, kart numarası, son kullanma tarihi ve CVV bilgileri alınır.

- **Havale**  
  Sistem tarafından otomatik IBAN bilgisi sağlanır.

- **Nakit**

---

## 🧾 Kiralama Geçmişi

- Yapılan tüm kiralamalar `RentalRecord` sınıfı ile kayıt altına alınır.
- Araç iade edildiğinde, kiralama durumu **“İade Edildi”** olarak güncellenir.
- Kiralama tarihi, süre ve toplam ücret bilgileri görüntülenebilir.

---

## 🧪 Testler

Proje kapsamında **JUnit 5** kullanılarak birim testler yazılmıştır.

Test edilen başlıca alanlar:
- Araç listeleme
- Araç kiralama
- Araç iade işlemleri
- Envanter filtreleme

---

## 📚 JavaDoc

Tüm sınıflar ve önemli metotlar için **JavaDoc açıklamaları** eklenmiştir.  
JavaDoc çıktısı `doc/` klasörü altında oluşturulmuştur.

---
