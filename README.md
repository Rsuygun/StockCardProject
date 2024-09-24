# Stok Kartı - Yeterlilik Ölçme Çalışması

Bu proje, bir işletmedeki stokların kimlik bilgilerinin oluşturulması, güncellenmesi, listelenmesi ve silinmesi işlemlerini gerçekleştirmek amacıyla geliştirilmiştir. Uygulama, Java (Version 1.8) programlama dili ile geliştirilmiş olup, Swing arayüz tasarım framework'ü kullanılarak masaüstü ortamında çalışacak şekilde tasarlanmıştır. Veritabanı olarak MySQL (Version 8) kullanılmıştır ve tercih edilen IDE Eclipse (Version 2022-09)'dir.

## Proje Yapısı

### Veritabanı Tasarımı

Projenin veritabanı, stok bilgilerini kaydetmek için aşağıdaki tabloyu içermektedir:

| Alan Adı        | Veri Tipi           | UI Component     |
|-----------------|---------------------|------------------|
| id            | INT(11) AI PK     | TextField      |
| Stok Kodu     | VARCHAR(50) Unique| TextField      |
| Stok Adı      | VARCHAR(100)      | TextField      |
| Stok Tipi     | INT(2)            | ComboBox       |
| Birimi        | VARCHAR(10)       | ComboBox       |
| Barkodu       | VARCHAR(30)       | TextField      |
| KDV Tipi      | Double            | ComboBox       |
| Açıklama      | Text              | TextArea       |
| Oluşturma Zamanı | DateTime        | FormattedTextField |

### Kullanıcı Arayüzü

Kullanıcı arayüzünde, stok bilgilerini oluşturmak, güncellemek ve listelemek için çeşitli bileşenler bulunmaktadır. Proje arayüzü Swing kütüphanesi ile yapılmıştır ve her veri alanı, yukarıda belirtilen UI bileşenleri ile ilişkilendirilmiştir.

### Özellikler

1. *Yeni Stok Kartı Oluşturma*: Kullanıcı, arayüzdeki ilgili alanları doldurarak yeni bir stok kartı oluşturabilir ve "Kaydet" butonuna basarak veritabanına kaydedebilir.
   
2. *Stok Kartı Güncelleme*: Var olan stok kartları, listede seçildikten sonra düzenlenebilir ve güncellenmiş bilgiler kaydedilebilir.

3. *Stok Kartı Listeleme*: Kayıtlı tüm stok kartları JTable kullanılarak listelenir. Kullanıcı, listedeki stok kartlarına çift tıklayarak stok detaylarını görebilir.

4. *Stok Kartı Kopyalama*: Kullanıcı, mevcut bir stok kartını kopyalayarak yeni bir stok kartı oluşturabilir. Bu işlem sırasında, stok kodu hariç tüm bilgiler kopyalanarak yeni karta aktarılır.

5. *Arama Fonksiyonu*: Liste üzerinde dolaşırken stok kartına ait bilgileri arayarak filtreleme yapılabilir.

### Dikkat Edilmesi Gerekenler

- *Kurumsal Mimari*: Proje geliştirilirken kurumsal mimariye uygun yazılım geliştirilmesine özen gösterilmelidir.
- *Teknolojiler*:
  - Programlama Dili: Java (Version 1.8)
  - Arayüz Tasarım Framework: Swing
  - Veritabanı: MySQL (Version 8)
  - IDE: Eclipse (Version 2022-09)

## Kurulum Adımları

1. *Projeyi klonlayın*:
    bash
    git clone https://github.com/kullaniciadi/proje-adi.git
    

2. *MySQL Veritabanını Hazırlayın*:
   MySQL'de bir veritabanı oluşturun ve yukarıdaki tabloya uygun yapıyı oluşturun.

3. *Veritabanı Bağlantısını Yapılandırın*:
   Java projesindeki veritabanı bağlantı bilgilerini, yerel veritabanınıza uygun şekilde yapılandırın.

4. *Projenin Derlenmesi ve Çalıştırılması*:
    Eclipse IDE kullanarak projeyi açın ve çalıştırın.

## Katkıda Bulunma

Projeye katkıda bulunmak için lütfen önce bir issue açarak değişiklik yapmayı tartışın. Her türlü katkıya açığız!

## Lisans

Bu proje MIT Lisansı altında lisanslanmıştır. Daha fazla bilgi için LICENSE dosyasına bakın.
