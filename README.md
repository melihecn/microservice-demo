# Spring Boot Mikroservis Projesi

Bu proje, **Order, Product ve Inventory servisleri** ile bir **API Gateway** içeren basit bir mikroservis mimari uygulaması.
Proje *Docker* ile çalışmakta ve database olarak *PostgreSQL* ile *MongoDB*, mikroservis iletişimi için *Apache Kafka* kullanmaktadır. 
Fault tolerance için de *Resilience4j* kullanılıyor.

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
- Database PostgreSQL ve MongoDB
- Docker
- OpenFeign (http client kütüphanesi)
- Apache Kafka (mikroservisler arası mesajlaşma)
- Resilience4j (fault tolerance)
- Maven (her servis için)

---

## Kullanım

### 1. Docker ile servisleri ayağa kaldır

Projeyi klonladıktan sonra ana dizinde:

```bash
docker-compose up -d
```

### 2. Her mikroservisi IDE üzerinden çalıştır

Sırayla
1. DemoApplication 
2. InventoryServiceApplication
3. OrderServiceApplication
4. ApiGatewayApplication
