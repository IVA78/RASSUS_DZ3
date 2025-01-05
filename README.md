# Treća laboratorijska vježba — Mikroservisi i Kubernetes

Ovaj repozitorij sadrži izvorni kôd za projekt raspodijeljenog sustava senzorske mreže, razvijen kao dio laboratorijske vježbe iz kolegija Raspodijeljeni sustavi na FER3, akademska godina 2024./2025.

## Funkcionalnost
1. Mikroservis za temperaturu
    - Izlaže HTTP sučelje koje vraća trenutnu temperaturu u Celzijusima.
    - Podaci se dohvaćaju iz datoteke readings.csv i pohranjuju u lokalnu bazu podataka.
2. Mikroservis za vlagu
    - Izlaže HTTP sučelje koje vraća trenutnu vrijednost vlage u postocima.
    - Također koristi ulaznu datoteku readings.csv za generiranje podataka.
3. Mikroservis za agregaciju
    - Dohvaća podatke od mikroservisa za temperaturu i vlagu te ih agregira.
    - Podržava konfiguraciju temperaturne jedinice (Celzijusi ili Kelvini).

## Arhitektura sustava
Raspodijeljeni sustav sastoji se od sljedećih komponenti:
1. Mikroservisi za obradu podataka
    -Temperatura i vlaga se procesiraju odvojeno kako bi se pojednostavila funkcionalnost i omogućila fleksibilnost u razvoju.
2. Mikroservis za agregaciju
    - Centralna komponenta koja koordinira rad mikroservisa i agregira rezultate.
3. Kubernetes grozd
    - Osigurava orkestraciju, skalabilnost i upravljanje resursima sustava.
4. ConfigMap i PersistentVolume
    - Učitavanje ulaznih podataka i konfiguracija putem Kubernetes resursa za vanjsku pohranu.

## Značajke sustava
- Modularnost: Svaki mikroservis je samostalna jedinica s vlastitim kodom, konfiguracijom i funkcionalnošću.
- Kontejnerizacija: Mikroservisi su pakirani kao Docker slike, što omogućuje jednostavno postavljanje i skaliranje.
- Konfigurabilnost: Koriste se Kubernetes ConfigMap resursi za učitavanje konfiguracijskih datoteka izvana.
- Skalabilnost: Kubernetes Deployment resursi omogućuju skaliranje mikroservisa prema opterećenju.
- Agregacija podataka: Mikroservis za agregaciju prikuplja i obrađuje podatke iz drugih servisa, pružajući objedinjeni odgovor klijentu.

## Tehnologije
- Java 21 i Spring Boot 3.4.0 za implementaciju mikroservisa.
- Gradle za upravljanje projektom.
- Docker za kontejnerizaciju.
- Kubernetes za orkestraciju mikroservisa.

## Autor
- Iva Svalina
- Fakultet elektrotehnike i računarstva, Sveučilište u Zagrebu
