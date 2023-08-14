import random 
list=["r","m"]
with open('referencias32_64_75.txt','w') as f:
    f.write(str(32))
    f.write("\n")
    f.write(str(64))
    f.write("\n")
    f.write(str(500))
    f.write("\n")
    for i in range (500):
        f.write(str(random.randint(0,63)))
        f.write(",")
        f.write(str(list[random.randint(0,1)]))
        f.write("\n")
    f.close()
    

   