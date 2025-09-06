# Spring Boot Mikroservis Projesi

Bu proje, **Order, Product ve Inventory servisleri** ile bir **API Gateway** içeren basit bir mikroservis mimari uygulaması.
Proje Docker ile çalışmakta ve database olarak PostgreSQL ile MongoDB, mikroservis iletişimi için Spring Cloud OpenFeign kullanmaktadır. 

## Servisler

| Servis      | Açıklama                                | Veritabanı     |
|-------------|-----------------------------------------|----------------|
| Order       | Sipariş yönetimi                        | PostgreSQL     |
| Product     | Ürün yönetimi                           | MongoDB        |
| Inventory   | Stok yönetimi                           | PostgreSQL     |
| API Gateway | Tüm servisleri tek noktadan handle eder | ---            |

---

## Teknolojiler

- Spring Boot (Java)
- PostgreSQL
- MongoDB
- Docker
- OpenFeign
- Maven (her servis için)

---

## Kullanım

### 1. Docker ile servisleri ayağa kaldır

Projeyi klonladıktan sonra her bir klasörde:

```bash
docker-compose up -d
```

### 2. Her bir mikroservisi IDE üzerinden çalıştır

