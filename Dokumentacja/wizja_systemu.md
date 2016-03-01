#Wizja Systemu oraz Wzbogacony Wizerunek

![baza](http://zapodaj.net/images/e84e02031a53a.jpg)

1. Opis:
  
  Inteligentna książka kucharska to aplikacja, która ma być pomocna w przygotowywaniu dań w codziennym życiu. Głównym założeniem jest   wybranie z listy dostępnych w bazie składników, jakie posiada w domu użytkownik aplikacji, a następnie system wyszukuje potrawy       jakie można sporządzić z wybranych składników. 
  Dodatkowymi funkcjonalnościami będą: 
  lista gotowych przepisów, które może przeglądać użytkownik, skorzystać z nich i następnie ocena danego przepisu
  proponowanie nowych składników ze strony użytkownika i akceptacja ich przez administratora
  proponowanie nowych przepisów przez użytkownika oraz dodanie ich po uprzedniej akceptacji przez administratora

2. Cele systemu (biznesowe)
  
  Aplikacja jest wdrażana w celu proponowania przepisu na ciekawy posiłek, gdy nie mamy pomyslu.
  
  Korzyści wynikające z wdrożenia systemu to:
  - przyspieszenia i ułatwienia sporządzania dań
  - oszczędności czasu w przygotowywaniu
  - poszerzenie wiedzy kucharskiej

3. Kontekst systemu

  Użytkownicy aplikacji:
  
  - Użytkownik – główny odbiorca aplikacji, może korzystać z systemu z poziomu własnego konta lub 		jako gość (bez potrzeby logowania do systemu).
  
  - Administrator – zarządca aplikacji, posiadający wszelkie uprawnienia do wprowadzania i 			zatwierdzania zmian w programie.
  
  Aplikacja będzie działała niezależnie od innych systemów.






4. Zakres funkcjonalności

  Użytkownik (bez logowania do systemu) może:
  - przeglądać przepisy
  - proponować zmiany w aplikacji
  - wybierać składniki z posiadanych
  - wyszukiwać przepisy
  
  Po zalogowaniu jego funkcjonalności zwiększają się o:
  - proponowanie przepisu
  - proponowanie nowego składnika
  - ocenę przepisu
  
  Administrator może:
  - zarządzać bazą przepisów
  - zarządzać bazą składników
  - zajmować się akceptowaniem ocen przepisów wystawianych przez zwykłego użytkownika
  
  
   
  ######Diagram przypadków użycia:

  ![diagramprzypadkowuzycia](http://zapodaj.net/images/d45197041cb17.jpg)


5. Wymagania jakościowe

  Wszelkie zmiany, które mają zostać wprowadzone w aplikacji np. dodanie nowego przepisu mogą być przeprowadzone tylko poprzez konto    administratora zabezpieczone hasłem . Każdy użytkownik może założyć swoje konto również zabezpieczone hasłem. Wszystko co się dzieje   w systemie jest monitorowane przez administratora i tylko przez niego akceptowane. Takie zastosowanie pozwala na uniknięcie błędów,   niepoprawności i niespójności danych, selekcję ocen tylko na te, które są związane z faktyczną oceną przepisu. Interfejs aplikacji    będzie graficzny a co za tym idzie przejrzysty.

6. Ograniczenia

  Aplikacja łączy się z bazą danych, w której przechowywane są przepisy i składniki, z której użytkownicy mogą je tylko odczytywać,     wyszukiwać. Dodawanie nowych przepisów, składników do bazy może wykonać administrator. Proponowane nowe składniki lub przepisy przez   użytkownika nie trafiają bezpośrednio do bazy tylko do administratora.

7.  Wizualizacja bazy danych
  ![baza](http://zapodaj.net/images/3a97199a83a6f.png)
