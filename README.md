# URL SHORTNER <br/>
A URL shortner created using Java, Mongodb, spring boot and gradle.

## Features
- Shorten a URL using rest endpoints
- The short URL is a basic string made of lower case alphabets, upper case alphabets and numbers.
- The URL gets saved in the database. Hence, we get the same short string every time for the same URL.
- We can recover the original URL using the short URL corresonding to it.

## Setup
Run the following command to build the project.
````
./gradlew build
````
Run the following command to run the project.
````
./gradlew bootRun
````


## Use
Now that the URL shortner is running, we can use it as follows-
- To shorten a given URL, run the following command-<br/>
  ````
  curl -w "\n" http://localhost:8080/shorten/type_Your_URL_here
  ````
  The URL provided in the request must be a valid URL(it should start with `http://` or `https://`), else `Invalid URL` will be returned.<br/>
  For example, If you want to shorten `https://www.youtube.com`, run the following command-<br/>
  
  ````
  curl -w "\n" http://localhost:8080/shorten/https://www.youtube.com
  ````
- To recover the original url from a given short url, run the following command-<br/>
  
  ````
  curl -w "\n" http://localhost:8080/recover/type_the_short_URL_here
  ````
  If the short URL has no corresponding URL in the database, `Not Found in the database` will be returned. <br/>
  For example, If you want to check what URL is mapped to short url `abA2`, run the following command-<br/>
  
  ````
  curl -w "\n" http://localhost:8080/recover/abA2
  ````
## Testing
If you want to test the url shortner, you can enter random URLs using the pyscript.py. For making **n** random URL requests, run the following command-<br/>

````
python3 pyscript.py n
````
