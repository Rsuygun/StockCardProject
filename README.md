# Stock Card Project

This project has been developed to manage the identification information of stock in a business, including creating, updating, listing, and deleting stock records. The application is built using Java (Version 1.8) and designed to run in a desktop environment using the Swing framework for the user interface. MySQL (Version 8) is used as the database, and the preferred IDE is Eclipse (Version 2022-09).

## Project Structure

### Database Design

The database for the project includes the following table to store stock information:

| Field Name         | Data Type          | UI Component      |
|--------------------|--------------------|-------------------|
| id                 | INT(11) AI PK      | TextField         |
| Stock Code         | VARCHAR(50) Unique  | TextField         |
| Stock Name         | VARCHAR(100)       | TextField         |
| Stock Type         | INT(2)            | ComboBox          |
| Unit               | VARCHAR(10)       | ComboBox          |
| Barcode            | VARCHAR(30)       | TextField         |
| VAT Type           | Double            | ComboBox          |
| Description        | Text               | TextArea          |
| Creation Time      | DateTime          | FormattedTextField|

### User Interface

The user interface includes various components for creating, updating, and listing stock information. The project interface has been developed using the Swing library, and each data field is associated with the UI components mentioned above.

### Features

1. *Create New Stock Card*: The user can create a new stock card by filling in the relevant fields in the interface and clicking the "Save" button to store it in the database.
   
2. *Update Stock Card*: Existing stock cards can be edited and updated with new information after being selected from the list.

3. *List Stock Cards*: All registered stock cards are listed using a JTable. Users can double-click on the stock cards in the list to view the details.

4. *Copy Stock Card*: The user can create a new stock card by copying an existing one. During this process, all information except the stock code is copied to the new card.

5. *Search Functionality*: Users can filter stock cards by searching for information while navigating through the list.

### Important Considerations

- *Corporate Architecture*: Care should be taken to ensure that software development adheres to corporate architecture during the project development.
- *Technologies*:
  - Programming Language: Java (Version 1.8)
  - UI Design Framework: Swing
  - Database: MySQL (Version 8)
  - IDE: Eclipse (Version 2022-09)

## Installation Steps

1. *Clone the project*:
    ```bash
    git clone (https://github.com/Rsuygun/StockCardProject)
    ```

2. *Prepare the MySQL Database*:
   Create a database in MySQL and set up the structure according to the table mentioned above.

3. *Configure the Database Connection*:
   Adjust the database connection settings in the Java project to match your local database.

4. *Build and Run the Project*:
    Open the project in Eclipse IDE and run it.


---

# Stok Kartı Projesi

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
    git clone (https://github.com/Rsuygun/StockCardProject)
    

2. *MySQL Veritabanını Hazırlayın*:
   MySQL'de bir veritabanı oluşturun ve yukarıdaki tabloya uygun yapıyı oluşturun.

3. *Veritabanı Bağlantısını Yapılandırın*:
   Java projesindeki veritabanı bağlantı bilgilerini, yerel veritabanınıza uygun şekilde yapılandırın.

4. *Projenin Derlenmesi ve Çalıştırılması*:
    Eclipse IDE kullanarak projeyi açın ve çalıştırın.


