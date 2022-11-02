----- DATABASE -----

Per utilizzare l'applicazione bisogna avere installata l'istanza del DB MySQL.
- Installare MySQL Workbench e creare una propria istanza
- Creare un DB chiamato notes_db con due tabelle (users e notes)
- La tabella users avrà 4 colonne (id, name, email, password)
- La tabella notes avrà 4 colonne (id, title, note, user_id)

----- JAVA -----
- Installare l'ide Eclipse
- Una volta all'interno di Eclipse, recarsi all'interno del suo marketplace (in genere si trova all'interno della scheda aiuto) e cercare l'estenzione Spring Tools 4, quindi installarla
- Importare il progetto all'interno di Eclipse, tramite File -> Apri progetto dal file system
- Modificare il file application.properties, inserendo le credenziali della propria istanza del db MySQL
- A questo punto, l'applicazione può essere avviata, cliccando con il tasto destro del mouse sul progetto all'interno di Eclipse e proseguendo su Run as-> Springboot application 

----- Angular -----
- Aprire il progetto in Visual Studio Code
- Da terminale, lanciare il comando npm i
- Avviare il client lanciando il comando da terminale ng serve