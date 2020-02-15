#!/usr/bin/env python3

import pandas as pd 

data = pd.read_csv("factores.csv")

for i in range(data.shape[0]):                
    print("{", end="")             
    row = data.values[i]           
    for j in range(1, len(row)):   
        if j>1: print(", ", end="")   
        print(row[j], end="")      
    print("},")