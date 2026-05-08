Теодора Златковска 245002


### **Control flow graph**

*searchBookByTitle*
<img width="430" height="620" alt="searchBookByTitle" src="https://github.com/user-attachments/assets/31eb67d0-5cb2-478a-b413-4e80cb8f0d52" />


*borrowBook*
<img width="430" height="620" alt="borrowBook" src="https://github.com/user-attachments/assets/e52480a0-edfd-43eb-a206-774327e3894a" />



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
| A    | *      | *      | *      |
| B    | *      |        |        |
| C    |        | *      | *      |
| D    |        | *      | *      |
| E    |        | *      | *      |
| F    |        | *      |        |
| G    |        | *      | *      |
| H    |        |        | *      |
| I    |        | *      |        |

Минималниот број на потребни тест случаји за функцијата *searchBookByTitle* според Every statement критериумот е 3. 

Првиот тест е за случај кога насловот не е даден и се фрла исклучок, односно ги покрива линиите A и B.

Вториот тест е кога бараме книга која постои во library и не е позајмена, односно ги покрива линиите A, C, D, E (true), F, G (false) и I.

Третиот тест е кога бараме книга која не постои во library, односно ги покрива линиите A, C, D, E (false), G (true) и H. 

### **Тест случаи според критериумот Every branch**

| Branch | Test 1 | Test 2 | Test 3 | Test 4 |
|--------|--------|--------|--------|--------|
| A->B   | *      |        |        |        |
| A->C   |        | *      | *      | *      |
| C->D   |        | *      | *      | *      |
| C->J   |        | *      |        |        |
| D->C   |        | *      | *      | *      |
| D->E   |        |        | *      | *      |
| E->F   |        |        | *      |        |
| E->H   |        |        |        | *      |
| F->G   |        |        | *      |        |
| G->I   |        |        | *      |        |

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
