Теодора Златковска 245002


### **Control flow graph**

*searchBookByTitle*
<img width="429" height="621" alt="searchBookByTitle" src="https://github.com/user-attachments/assets/2a1df429-2f0d-4489-a695-58e231ae1cca" />

*borrowBook*
<img width="429" height="621" alt="borrowBook" src="https://github.com/user-attachments/assets/6b9c496a-fa53-444a-bf6d-62e02e9f9f1f" />

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

Третиот тест е кога бараме книга која не постои во library, односно ги покрива линиите 1, 3, 4, 5 (true), 7 (true) и 8. 

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

Третиот тест случај е кога имаме книга која постои во library и не е позајмена. For циклусот ги изминува книгите и ја наоѓа бараната книга, условот (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) е исполнет, условот (!book.isBorrowed()) е исполнет, книгата се означува како позајмена. 

Четвртиот случај е кога имаме книга која постои во library и е позајмена. For циклусот ги изминува книгите и ја наоѓа бараната книга, условот (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) е исполнет, условот (!book.isBorrowed()) не е исполнет, фрла исклучок. 

### **Multiple Condition за условот *borrowBook***

Условот гласи: (title.isEmpty() || author.isEmpty())

Земаме A=title.isEmpty(), B=author.isEmpty()

|        | A | B | A OR B |
|--------|---|---|--------|
| Test 1 | * | * | *      |
| Test 2 | * |   | *      |
| Test 3 |   | * | *      |
| Test 4 |   |   |        |

За операторот OR да е true, мора барем еден од подусловите A и B да е true. Затоа, тука се можни 4 комбинации. Според тоа заклучуваме дека минималниот број на потребни тест случаји е 4.

### **Multiple Condition за условот *searchBookByTitle***

Условот гласи: (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed())

Земаме A=book.getTitle().equalsIgnoreCase(title), B=!book.isBorrowed()

|        | A | B | A AND B |
|--------|---|---|---------|
| Test 1 | * | * | *       |
| Test 2 | * |   |         |
| Test 3 |   | * |         |
| Test 4 |   |   |         |

За операторот AND да е true, мора и двата подуслови A и B да се true. Тука имаме 4 можни комбинации. Според тоа заклучуваме дека минималниот број на потребни тест случаји е 4.
