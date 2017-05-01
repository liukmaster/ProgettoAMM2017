


<!DOCTYPE html>
<html>
    <head>
        <title>Bacheca</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Luca Fadda">
        <LINK REL="stylesheet" TYPE="text/css" HREF="style.css">
    </head>
    <body>
        
        <header>
                <h1>NerdBook</h1>
        </header> 
        
        <nav class="BachecaNav">
               
                <ul>
                     
                     <li><a href="profilo.html">Profilo</a></li>
                    <li class="attivo"><a href="bacheca.html">Bacheca</a></li>
                   
                </ul>
            <div class="utenteLoggato">
                <p>Luca Fadda</p>
            </div>
            <div class="logout">
                <p><a href="">Logout</a></p>
            </div>
        </nav>
        
        <div class="left">
                
                <input type="text" class="search" name="search">
                <h2>Persone</h2>
                <p class="spaPersone">Pinco Pallino</p>
                <p class="spaPersone">Riccardo Rossi</p>
                <p class="spaPersone">Mario Bianchi</p>
            
            
                <h2>Gruppi</h2>
                <p class="spaGruppi">Mongolfieristi</p>
                <p class="spaGruppi">Ritardatari</p>
            
        </div>
        <div class="strutturaBacheca">
        
            <div id="postNormale" class="postNormale">
                 <p class="a">Post Normale</p>
                <p class="autorePost">Luca Giurato<p>
                <p>Il linguaggio Java e' un linguaggio di programmazione ad alto livello, 
                   orientato agli oggetti<br/></p>
                <p>Java venne creato per soddisfare cinque obiettivi primari:<br/> </p>
                <ul>
                    <li>essere "semplice, orientato agli oggetti e familiare";<br/></li>
                    <li>essere "robusto e sicuro"<br/></li>
                    <li>essere indipendente dalla piattaforma;<br/></li>
                    <li>contenere strumenti e librerie per il networking;<br/></li>
                    <li>essere progettato per eseguire codice da sorgenti remote in modo sicuro.<br/></li> 
                </ul>
            </div>
            <div id="postImmagine" class="postImmagine">
                <p class="a">Post con immagine</p>
                <p class="autorePost">Luca Giurato</p>
                <p>Un esempio di codice scritto in Java</p>
               <!-- <img title="computer" src="immagini/Jnodo.jpg" alt="immagine non trovata" height="350" width="350"> -->
            </div>
            <div id="postURL" class="postURL">
                 <p class="a">Post con URL</p>
                <p class="autorePost">Luca Giurato</p>
                <p>Questo e' il link che riporta a Wikipedia per il linguaggio Java</p>
                <a class="linkJava" href="https://it.wikipedia.org/wiki/Java_(linguaggio_di_programmazione)" target="_blank">JavaWiki</a>
            </div>
        </div>
       
        <footer>
            <div id="contatti" class="contatti">
                    <h2>CONTATTI</h2>
                <p>Luca Fadda Cagliari liukfadd@hotmail.it - Tel: 3481415700</p>
            </div>
            <div id="chisono" class="chisono">
                    <h2>CHI SONO</h2>
                    <p>Sono Luca e questo e' il mio sito. Sono un laureando</p>
            </div>
            <div id="argomenti" class="argomenti">
                <h2>ARGOMENTI</h2>
                <p>
                 Linguaggi informatici, in particolare Java 
                </p>
            </div>   
        </footer>
    </body>
</html>
