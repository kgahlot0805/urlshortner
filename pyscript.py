import sys
import os
import random
import time

start_time = time.time()

preurl = "curl -w \"\\n\" http://localhost:8080/shorten/https://"
c = int(sys.argv[1])
for i in range(c):
  #len = random.randrange(6, 25)
  len=13
  keyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
  midurl = ""
  for i in range(len):
    midurl = midurl + keyString[random.randrange(100,1000)%62];
  url = preurl + midurl + ".com"
  #print(url)
  os.system(url)

print("--- %s seconds ---" % (time.time() - start_time))