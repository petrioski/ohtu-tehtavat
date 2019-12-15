# Ohjelmistotuotanto

## Ohjelmistotuotannon osa-alueet
SWEBOK:in mukaan ohjelmistotuotanto jakautuu seuraaviin osa-alueisiin:

* Software requirements (*)
* Software design (*)
* Software construction (*)
* Software testing (*)
* Software maintenance (*)
* Software configuration management
* Software engineering management
* Software engineering process
* Software engineering models and methods
* Software quality

Tähdellä merkityt (*) kohdat muodostavat ohjelmiston vaiheet ja elinkaaren.

## Ohjelmistokehitys insinööritieteenä: software engineering
Ohjelmistokriisin (1968) julistamisen jälkeen siirryttiin kohti systemaatisempaa ohjelmistokehitystä insinööritieteen analogian pohjalta. Ohjelmistojen kehittämisen tulisi olla kuin mikä tahansa muu insinöörityö, eli kuten esim. siltojen rakentamisessa, tulee rakennettava artefakti ensin määritellä (requirements) tarkasti ja suunnitella (design) aukottomasti ja tämän jälkeen rakentaminen (construction) on melko suoraviivainen vaihe.
 
### Vesiputous- eli lineaarinen malli
Vesiputousmalli oli yksi suosituimpia systemaattisia kehitysmalleja 1970-luvulla. Mallille oli tunnusomaista:
- ohjelmiston elinkaaren vaiheet suoritetaan lineaarisesti peräkkäin
- Vesiputousmalli perustuu vahvasti siihen, että eri vaiheet ovat erillisten tuotantotiimien tekemiä.
- Jotta tieto kulkee ohjelmistokehityksen eri vaiheiden välillä, tulee kunkin vaiheen tulokset dokumentoida huolellisesti.
- Vesiputousmallin mukainen ohjelmistoprosessi on yleensä tarkkaan etukäteen suunniteltu, resursoitu ja aikataulutettu

#### lineaarisen ohjelmakehityksen ongelmat
- Useimmiten on mahdotonta määritellä ohjelmiston vaatimukset tyhjentävästi projektin alkuvaiheessa. Asiakas ei yleensä ymmärrä vielä alussa mitä haluaa ja bisnesympäristö muuttuu projektin kuluessa.
    - huolimatta huolellisesta vaatimusmäärittelystä, ohjelmistokehittäjät eivät välttämättä osaa tulkita kirjattuja vaatimuksia siten kuin asiakas on tarkoittanut
- Suunnittelu sillä tasolla, että ohjelmointi on triviaali ja ennustettava rakennusvaihe, rinnastettavissa esim. talon rakennukseen, on mahdotonta.
- Ohjelmointi on osa suunnitteluprosessia, ohjelmakoodi on tuotteen lopullinen suunnitelma. Suunnittelu taas on teknisesti haastavaa, riskejä sisältävää toimintaa.
- Keskiössä on siis tarkka projektisuunnitelma (joka toki iteratiivisissa malleissa voi elää) ja sen noudattaminen

### Iteratiivinen ja inkrementaalinen ohjelmistokehitys
- Lineaarisen mallin ongelmiin reagoinut iteratiivinen tapa tehdä ohjelmistoja alkoi yleistyä 90-luvulla (mm. spiraalimalli, prototyyppimalli, Rational Unified process).
- Iteratiivisessa mallissa ohjelmistotuotanto jaetaan pienempiin aikaväleihin, eli iteraatioihin. 
- iteratiivisesti edetessä ei pyritä tekemään heti alussa kattavaa määrittelyä ja suunnittelua.

### Ketterä ohjelmistokehitys

Vastareaktiona vesiputous- ja muihin prosessimalleihin syntyi erilaisia ketteriä metodeja. Toisaalta ketterät menetelmät vaikuttavat jatkumolta iteratiivisen ohjelmistokehitykselle, missä iteraation ideaa on viety pidemmälle. 

Ketteryys voidaan nähdä sateenvarjoterminä useille menetelmille. Menetelmistä extreme programming oli suosituin vuosituhannen alussa, mutta sittemmin Scrum on noussut suosituimmaksi.

Ketterät menetelmät ovat ottaneet paljon vaikutteita Toytota production systemin lean-ajattelusta. Samoin extreme programming käytänteistä moni on jäänyt uudempiin menetelmiin. Esimerkiksi yhtäläisyys scrumiin näkyy selkeästi XP:n toimintaa kuvaavassa [flow chartissa](http://www.extremeprogramming.org/map/project.html)

#### Ketterät periaatteet
[Ketterän ohjelmistokehityksen manifestissa](http://agilemanifesto.org/) on 12 periaatetta
1. Our highest priority is to satisfy the customer through early and continuous delivery of valuable software.

1. Deliver working software frequently, from a couple of weeks to a couple of months, with a preference to the shorter timescale.

1. Working software is the primary measure of progress.

1. Business people and developers must work together daily throughout the project.

1. The most efficient and effective method of conveying information to and within a development team is face-to-face conversation.

1. Welcome changing requirements, even late in development. Agile processes harness change for the customer’s competitive advantage.

1. Build projects around motivated individuals. Give them the environment and support they need, and trust them to get the job done.

1. The best architectures, requirements, and designs emerge from self-organizing teams.

1. At regular intervals, the team reflects on how to become more effective, then tunes and adjusts its behavior accordingly.

1. Simplicity – the art of maximizing the amount of work not done – is essential.

1. Continuous attention to technical excellence and good design enhances agility.

1. Agile processes promote sustainable development. The sponsors, developers, and users should be able to maintain a constant pace indefinitely.




