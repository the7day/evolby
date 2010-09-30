Návod na instalaci pùvodního projektu.

Na SVN do složky trunk jsem nahrál 6 netbeans projektù - naši aplikaci e-volby. 

Docela dobøe se to dá rozchodit pomocí návodu, co nám nechali u dokumentace - dal jsem to i do této složky, 
jen pár detailù jsem musel pozmìnit, aby mi to chodilo. 
Takže si podle návodu nainstalujete:

1. aplikaèní server Glassfish 2 
2. DB Mysql (pøi instalaci se nastavuje heslo - dejte "admin")
3. otevøete si v NetBeans projekty, které jsem dal na SVN. 
4. V Services - Databases(kontext. menu) - Register MySQL server (vyplnit podle návodu login:root passwd:admin) 
5. V kontext. menu MySQL serveru vytvoøíte 4 DB. Zeptá se to vždy jen na jméno DB a ty jsou: ControllerDB, CounterDB, persondb, ValidatorDB. - pøesnì takle jak to píšu. Pro jistotu jsem svoje nastavení DB ješte PrintScreenul.
6. Pokraèujte podle návodu v tom kroku jak máte deployovat jednotlivé moduly na server Glassfish. Modul je správnì deploynutý, když v pøíslušné DB vytvoøí tabulky a na serveru je vidìt - tak jak je to v návodu.
7. Aplikace se spustí v Netbeans tak, že spustíte modul EvolbyWeb2.


