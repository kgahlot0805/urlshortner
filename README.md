This is a URL shortner created using Java, Mongodb, spring boot and gradle.

To shorten a given URL (givenurl), visit `localhost:8080/shorten/givenurl`.<br/>
The givenurl must be a valid url (it should start with `http://` or `https://`), else `Invalid URL` will be returned.<br/>
The request will return a short url containing lower case and upper case alphabets and numbers in range [0-9].<br/>
For eg - If we want to shorten `https://www.youtube.com/`, we have to visit `localhost:8080/shorten/https://www.youtube.com/`.<br/>

To recover the original url from a given short url (shorturl), visit `localhost:8080/recover/shorturl`.<br/>
If the corresponding URL for this short url is present in the database, it will be returned.<br/>
For eg - If we want to check what URL is mapped to short url `abA2`, we have to visit `localhost:8080/recover/abA2` and if any URL corresponding to this is present in the database, it will be returned.<br/>

For connecting Mongodb to the project, only one collection needs to be created-<br/>
Name - "shorturl"<br/>

Schema
````
{ 
  urlString : String,
  id : Integer 
}
````
