import sys
import random
import time
import requests

start_time = time.time()

preurl = "http://localhost:8080/shorten/https://"
c = int(sys.argv[1])
for i in range(c):
  len = random.randrange(6, 25)
  keyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
  midurl = ""
  for i in range(len):
    midurl = midurl + keyString[random.randrange(100,1000)%62];
  url = preurl + midurl + ".com"
  response = requests.get(url)

print("--- %s seconds ---" % (time.time() - start_time))