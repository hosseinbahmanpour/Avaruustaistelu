*Aihe:* Avaruustaistelu on peli, missä kaksi avaruusalusta ottaa toisistaan mittaa eeppisessä taistelussa!

*Käyttäjät:* Kaksi pelaajaa.

*Kaikkien käyttäjien toiminnot:* Oman avaruusaluksen ohjaaminen näppäimistöllä, ja ohjusten ampuminen.

****Tavoitteet****

Pelaajat ohjaavat omia avaruusaluksia, joita voi lentää ympäriinsä 2D ympäristössä. Pelaajat ampuvat laaserilla ja fotonilla ja yrittävät tappaa toisiaan.

Aluksella vauhtia, joka hidastuu jos lisää vauhtia ei anneta. Mahdollisesti painovoima, tällä hetkellä alukset warppaavat ruudun eri laidoilta toiselle laidalle, ja luodit myös.

Alusten tulee menettää elämää jos niihin osuu luoteja tai fotoneja. Myös alusten törmäyksestä seuraa elämän menetystä.

Törmäyksissä fotonin tai toisen aluksen kanssa alus saa vauhtia törmäyksen antamaan suuntaan.


***** Luokat *****

******
|Main|
******
Main luokassa luodaan uusi Avaruustaistelu pelilogiikka ja käyttöliittymä, ja annetaan ne peliloopille, ja käynnistetään looppi.

***********************
*Pelilogiikka paketti:|
***********************
Avaruustaistelu - luokassa luodaan pelaaja, alus ja alusgrafiikka kahdesti, pelin kahdelle pelaajalle, eli koko pelin logiikka yhtyy tässä luokassa.

Pelaaja - sisältää pelaajan tiedot (nimi, elämä, alus), ja ampumisen metodit eri aseilla

Alus - jokaisella pelaajalla oma alus, jolla x ja y koordinaatiston tiedot, säde jolla voi laskea törmäyksiä ym. Myös alusta varten tarvittava väri tallennetaan tähän, niin eri aluksilla voi olla eri värejä. Liiku metodilla alus liikkuu haluttuun suuntaan.

Laaseri - ensimmäinen ehkä perus ase mikä aluksella on. Laseri luodaan aluksen nokasta kun pelaaja ampuu. Laserilla paikka ja säde. Laserilla on nopeus + aluksen antama alkunopeus. Laserilla myös elinikä, että kuolee pois tietyn ajan päästä jos ei osu mihinkään. 

SuperAse - kuten laaseri, mutta pitää odottaa että se on ladannut että voi ampua.

************************
|Peligrafiikka paketti:|
************************
Alusgrafiikka - aluksen piirtämiseen tarvittavat tiedot löytyvät täältä.

Laaserigrafiikka - laaserin piirtämiseen tarvittavat tiedot löytyvät täältä.

SuperAseGrafiikka - superaseen piirtämiseen tarvittavat tiedot löytyvät täältä.

***********************
|Pelimoottori paketti:|
***********************
PeliLooppi - peliloopissa liikutetaan alukset ja laaserit jota pelissä on ja kutsutaan tormaystarkistajan tarkista metodia, ja sen jälkeen kaikki piirretään, ja odotetaan että on kulunut tarpeeksi aikaa jotta saavutetaan haluttu frames per second, jonka jälkeen palataan loopin alkuun.

TormaysTarkistaja - tässä luokassa on metodi jossa käydään läpi kaikki pelissä olevat laaserit ja alukset ja tarkistetaan ovatko ne törmänneet.

*************************
|Kayttoliittyma paketti:|
*************************
Kayttoliittyma - luokassa luodaan swing utilities pohjainen graafinen käyttöliittymä pelille.

NappaimistonKuuntelija - luokassa kuunnellaan mitä näppäimiä pelin aikana painetaan, ja tehdään haluttuja toimintoja perustuen painettuihin nappeihin.

Piirtoalusta - luokassa piirretään kaikki pelin graafiset oliot.
