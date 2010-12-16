!!! NEPOUZIVAT !!! Aktualni navod v dokumentu Tutorial.

Návod na instalaci pùvodního projektu.

Na SVN do složky trunk jsem nahrál 6 netbeans projektù - naši aplikaci e-volby. 

Docela dobre se to dá rozchodit pomocí návodu, co nám nechali u dokumentace - dal jsem to i do této složky, 
jen pár detailù jsem musel pozmìnit, aby mi to chodilo. 
Takže si podle návodu nainstalujete:

1. aplikacní server Glassfish 2 
2. DB Mysql (pøi instalaci se nastavuje heslo - dejte "admin")
3. otevrete si v NetBeans projekty, které jsem dal na SVN. 
4. V Services - Databases(kontext. menu) - Register MySQL server (vyplnit podle návodu login:root passwd:admin) 
5. V kontext. menu MySQL serveru vytvoríte 4 DB. Zeptá se to vždy jen na jméno DB a ty jsou: ControllerDB, CounterDB, persondb, ValidatorDB. - presne takle jak to píšu. Pro jistotu jsem svoje nastavení DB ješte PrintScreenul.
6. Pokracujte podle návodu v tom kroku jak máte deployovat jednotlivé moduly na server Glassfish. Modul je správne deploynutý, když v príslušné DB vytvoøí tabulky a na serveru je videt - tak jak je to v návodu.
7. Aplikace se spustí v Netbeans tak, že spustíte modul EvolbyWeb2.


