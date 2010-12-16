Testovani pomoci selenium testuje nasledujici akce:
	Prihlaseni jako administrator, vytvareni voleb a prirazovani komisaru
	Prihlaseni jako komisar, vytvoreni volebni udalosti, prirazovani a odebirani volicu, komisarske akce
	Prihlaseni jako volic, nominovani.

Netestovano:
	Voleni a zobrazeni vysledku (problemy s appletem)

Podminky k testovani:
	Firefox
	Plugin Selenium IDE (http://seleniumhq.org/download/)
	Spustena aplikace evolby
	Prazdna databaze (pokud v databazi existuji zaznamy se shodnymi jmeny testy nemusi fungovat)
	existujici uzivatele admin, commissioner1, commissioner2, voter1, voter2. S hesly shodujicimi se s uzivatelskymi jmeny (pridani v glassfishi a v databazi, postup v dokumentu Tutorial)

Postup:
	Spusteni Firefoxu a selenium IDE
	Otevreni souboru "TestAll"
	Uprava portu v "Base URL", pokud nesouhlasi
	spusteni vsech testu (Play entire test suite) nebo jednotlive (Play current test case).Jednotlive testy jsou na sobe zavisle, spusteni v jinem poradi nemusi fungovat spravne!
	Pokud je vse zelene, tak testy probehly spravne. Cervena indikuje chybu.