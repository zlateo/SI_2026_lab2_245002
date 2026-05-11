Теодора Златковска 245002


### **Control flow graph**

*searchBookByTitle*
<img width="770" height="840" alt="searchBookByTitle" src="https://github.com/user-attachments/assets/6c28bb32-c9ec-4854-9080-0c18c23cec7a" />


*borrowBook*
<img width="770" height="1090" alt="image" src="https://github.com/user-attachments/assets/5b23f96f-6c83-447e-a416-7fc7cbc5eced" />



### **Цикломатска комплексност**

Цикломатската комплексност за методот *searchBookByTitle* изнесува 5. Бидејќи методот има вкупно 4 предикатни јазли (P):
1. if (title.isEmpty())
2. for (Book book : books)
3. if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed())
4. if (results.isEmpty()),

според формулата P+1, добиваме краен резултат 5.


Цикломатската комплексност за методот *borrowBook* изнесува исто 5. Бидејќи методот има вкупно 4 предикатни јазли (P):
1. if (title.isEmpty() || author.isEmpty())
2. for (Book book : books)
3. if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author))
4. if (!book.isBorrowed()),

според формулата P+1, добиваме краен резултат 5.

### **Тест случаи според критериумот Every statement**

| Line | Test 1 | Test 2 | Test 3 |
|------|--------|--------|--------|
| 1    | *      | *      | *      |
| 2    | *      |        |        |
| 3    |        | *      | *      |
| 4.1  |        | *      | *      |
| 4.2  |        | *      | *      |
| 4.3  |        | *      | *      |
| 5    |        | *      | *      |
| 6    |        | *      |        |
| 7    |        | *      | *      |
| 8    |        |        | *      |
| 9    |        | *      |        |
| 10   | *      | *      | *      |

Минималниот број на потребни тест случаји за функцијата *searchBookByTitle* според Every statement критериумот е 3. 

Првиот тест е за случај кога насловот не е даден и се фрла исклучок, односно ги покрива линиите 1, 2 и 10.

Вториот тест е кога бараме книга која постои во library и не е позајмена, односно ги покрива линиите 1, 3, 4.1, 4.2, 4.3, 5 (true), 6, 7 (false), 9 и 10.

Третиот тест е кога бараме книга која не постои во library, односно ги покрива линиите 1, 3, 4.1, 4.2, 4.3, 5 (false), 7 (true), 8 и 10. 

### **Тест случаи според критериумот Every branch**

| Branch   | Test 1 | Test 2 | Test 3 | Test 4 |
|----------|--------|--------|--------|--------|
| 1->2     | *      |        |        |        |
| 1->3.1   |        | *      | *      | *      |
| 2->11    | *      |        |        |        |
| 3.1->3.2 |        | *      | *      | *      |
| 3.2->10  |        | *      |        |        |
| 3.2->4   |        | *      | *      | *      |
| 10->11   |        | *      |        |        |
| 4->5     |        |        | *      | *      |
| 4->3.3   |        | *      | *      | *      |
| 3.3->3.2 |        | *      | *      | *      |
| 5->6     |        |        | *      |        |
| 5->8     |        |        |        | *      |
| 6->7     |        |        | *      |        |
| 8->11    |        |        |        | *      |
| 7->9     |        |        | *      |        |
| 9->11    |        |        | *      |        |

Минималниот број на потребни тест случаји за функцијата *borrowBook* според Every branch критериумот е 4.

Првиот тест случај е кога немаме валиден наслов. Условот (title.isEmpty() || author.isEmpty()) е исполнет и фрла исклучок.

Вториот тест случај е кога имаме книга која не постои во library. For циклусот ги изминува сите книги, условот (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) не е исполнет и фрла исклучок.

Третиот тест случај е кога имаме книга која постои во library и не е позајмена. For циклусот ги изминува книгите и ја наоѓа бараната книга, односно условот (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) е исполнет. Условот (!book.isBorrowed()) е исполнет, книгата се означува како позајмена. 

Четвртиот случај е кога имаме книга која постои во library и е позајмена. For циклусот ги изминува книгите и ја наоѓа бараната книга. Условот (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) е исполнет, условот (!book.isBorrowed()) не е исполнет, фрла исклучок. 

### **Multiple Condition за условот *borrowBook***

Условот гласи: (title.isEmpty() || author.isEmpty())

| title.isEmpty() \|\| author.isEmpty() | Test                                            |
|---------------------------------------|-------------------------------------------------|
| TX                                    | Title: "", Author: "J.R.R. Tolkien"             |
| FT                                    | Title: "1984", Author: ""                       |
| FF                                    | Title: "Clean Code", Author: "Robert C. Martin" |

TX: Не е внесен наслов, значи првиот подуслов title.isEmpty() е true. Вториот подуслов author.isEmpty() воопшто не се евалуира поради lazy evaluation. Се фрла exception.

FT: Внесен е валиден наслов, значи првиот подуслов е false. Нема внесено автор, затоа вториот подуслов е true. Се фрла exception.

FF: Внесени се и валиден наслов и валиден автор, значи двата подуслови се false. Условот не е исполнет, значи методот си продолжува нормално.

Минимален број на тест случаи за ова функција според Multiple condition критериумот e 3.

### **Multiple Condition за условот *searchBookByTitle***

Условот гласи: (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed())

| book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed() | Test                                  |
|---------------------------------------------------------------|---------------------------------------|
| TT                                                            | Title: "1984", book is not borrowed   |
| TF                                                            | Title: "The Hobbit", book is borrowed |
| FX                                                            | Title: "Dune", book is not in library |

TT: Насловот е ист со бараниот и книгата не е позајмена, па се додава во листата. Методот враќа листа со бараниот наслов.

TF: Насловот е ист со бараниот, но книгата е веќе позајмена, па книгата не се додава во листата. Методот враќа null. 

FX: Насловот не постои во библиотеката, па поради lazy evaluation, вториот подуслов не се евалуира. Методот враќа null.

Минимален број на тест случаи за ова функција според Multiple condition критериумот e 3.
