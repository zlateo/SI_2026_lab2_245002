Теодора Златковска 245002


### **Control flow graph**

*searchBookByTitle*
<img width="429" height="621" alt="searchBookByTitle" src="https://github.com/user-attachments/assets/2a1df429-2f0d-4489-a695-58e231ae1cca" />

*borrowBook*
<img width="572" height="792" alt="borrowBook" src="https://github.com/user-attachments/assets/6b9c496a-fa53-444a-bf6d-62e02e9f9f1f" />

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
| 4    |        | *      | *      |
| 5    |        | *      | *      |
| 6    |        | *      |        |
| 7    |        | *      | *      |
| 8    |        |        | *      |
| 9    |        | *      |        |

Минималниот број на потребни тест случаји за функцијата *searchBookByTitle* според Every statement критериумот е 3. 

Првиот тест е за случај кога насловот не е даден и се фрла исклучок, односно ги покрива линиите 1 и 2.

Вториот тест е кога бараме книга која постои во library и не е позајмена, односно ги покрива линиите 1, 3, 4, 5 (true), 6, 7 (false) и 9.

Третиот тест е кога бараме книга која не постои во library, односно ги покрива линиите 7 (true) и 8. 

### **Тест случаи според критериумот Every branch**

| Branch | Test 1 | Test 2 | Test 3 | Test 4 |
|--------|--------|--------|--------|--------|
| 1->2   | *      |        |        |        |
| 1->3   |        | *      | *      | *      |
| 3->4   |        | *      | *      | *      |
| 3->10  |        | *      |        |        |
| 4->3   |        | *      | *      | *      |
| 4->5   |        |        | *      | *      |
| 5->6   |        |        | *      |        |
| 5->8   |        |        |        | *      |
| 6->7   |        |        | *      |        |
| 7->9   |        |        | *      |        |

Минималниот број на потребни тест случаји за функцијата *borrowBook* според Every branch критериумот е 4.

Првиот тест случај е кога немаме валиден наслов. Условот (title.isEmpty() || author.isEmpty()) е исполнет и фрла исклучок.

Вториот тест случај е кога имаме книга која не постои во library. For циклусот ги изминува сите книги, условот (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) не е исполнет и фрла исклучок.

Третиот тест случај е кога имаме книга која постои во library и не е позајмена. For циклусот ги изминува сите книги, условот (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) е исполнет, условот (!book.isBorrowed()) е исполнет, книгата ја означува како позајмена. 

Четвртиот случај е кога имаме книга која постои во library и е позајмена. For циклусот ги изминува сите книги, условот (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) е исполнет, условот (!book.isBorrowed()) не е исполнет, фрла исклучок. 
