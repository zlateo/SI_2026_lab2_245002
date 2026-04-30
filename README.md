Теодора Златковска 245002


### **Control flow graph**

*searchBookByTitle*
<img width="429" height="621" alt="searchBookByTitle" src="https://github.com/user-attachments/assets/2a1df429-2f0d-4489-a695-58e231ae1cca" />

*borrowBook*
<img width="572" height="792" alt="borrowBook" src="https://github.com/user-attachments/assets/6b9c496a-fa53-444a-bf6d-62e02e9f9f1f" />

### **Цикломатска комплексност**

Цикломатската комплексност за методот searchBookByTitle изнесува 5. Бидејќи методот има вкупно 4 предикатни јазли (P):
1. if (title.isEmpty())
2. for (Book book : books)
3. if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed())
4. if (results.isEmpty()),

според формулата P+1, добиваме краен резултат 5.

Цикломатската комплексност за методот borrowBook изнесува исто 5. Бидејќи методот има вкупно 4 предикатни јазли (P):
1. if (title.isEmpty() || author.isEmpty())
2. for (Book book : books)
3. if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author))
4. if (!book.isBorrowed()),

според формулата P+1, добиваме краен резултат 5.

### **Тест случаи според критериумот Every statement**

Минималниот број на потребни тестови според овој критериум е 3. 

Првиот тест е за случај кога насловот не е даден, односно ги покрива линиите 1 и 2.

Вториот тест е кога бараме книга која постои во library и не е позајмена, односно линиите 1, 3, 4, 5 (true), 6, 7 (false) и 9.

Третиот тест е кога бараме книге која не постои во library, односно линиите 7 (true) и 8. 

| Line | Test 1 | Test 2 | Test 3 |
|------|--------|--------|--------|
| 1    | *   | *   | *   |
| 2    | *   |    |    |
| 3    |    | *   | *   |
| 4    |    | *   | *   |
| 5    |    | *   | *   |
| 6    |    | *   |    |
| 7    |    | *   | *   |
| 8    |    |    | *   |
| 9    |    | *   |    |
