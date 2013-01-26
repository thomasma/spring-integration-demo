BASIC SETUP
==========================
Download the source using 
    git clone url_to_this_repo

ActiveMQ and Mongodb
Install ActiveMQ and Mongodb. Start each of them with their default settings. 

Dataset
    Download the contributions dataset from http://fec.gov/disclosurep/PDownload.do. Download a state specific one to run through this faster.

Install my custom CSV parser, included in the root folder using Maven command.
    mvn install:install-file -Dfile=fft-0.8.jar -DgroupId=org.aver -DartifactId=fft -Dversion=0.8 -Dpackaging=jar    

Load this project into Eclipse. I use SpringSource STS..recommend that. Now go into LoadDataDrive and change the path to the location of the data file and now run the class.


BASIC MONGO SHELL COMMANDS
==========================
    show dbs (lists all the current databases).
    use <databasename> (database name I used is contributions).
    show collections (collection name I use is contribution).
    db.contribution.findOne() (finds one record and displays it).
    db.contribution.find({candNm:”name here”}) 
    db.contribution.getIndexes() (returns all the current index names).
    db.contribution.dropIndex({candNm:1}) (drop existing index).
    db.contribution.ensureIndex({candNm:1}) (create index).
    db.contribution.ensureIndex({contbrEmployer:1}) (create index).
    db.contribution.count() (get count of records in the collection).
    db.contribution.remove() (removes the collection).



