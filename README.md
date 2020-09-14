# STAB

## Synopsis

This project is a remake of the old system for completing studies at the TU Vienna, done by the deanery. The primary focus was to reproduce the website with newer technologies, the database access is not yet implemented and has been replaced by dummy data for testing purposes.

## Technologies

* JSF 2.2
* Primefaces 5.2
* Java 7

## Tools

* Maven 4
* Eclipse Mars
* Tomcat 7

## Motivation

After finishing my bachelor thesis, I was offered this project for my master studies. Because it was the counter part to the project I did for my bachelor thesis and I gladly accepted.

## Usage

The project can be built via maven. The resulting war file has to be run on a Tomcat7 or similar server. There is a predefined user with name 1234 and password asdf. After the login multiple tasks can be performed. The data is stored as long as the server keeps running.

## API

The Provider class handles the access to the dummy data which can be replaced by a database by changing its methods. For a better look of the model classes, check out the Generator class which creates the data on start up. 

## Author

Florian Waltenberger

## License

Copyright (C) 2016  Florian Waltenberger

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.

asdfasdf
asdfasdf
