
# coding: utf-8

# # Importing ReefBase Database and pushing data to Firebase
# The Dataset contains LatLong, Temp and Condition of reefs

# ### Importing Libraries

# In[75]:


import pandas as pd
import numpy as np

import random
import string

from firebase import firebase


# In[15]:


df = pd.read_excel('data/CoralBleaching.xlsx')


# In[16]:


df = df.drop(columns=['REGION', 'SUBREGION', 'COUNTRY', 'LOCATION', 'MONTH', 'YEAR', 'DEPTH', 'RECOVERY_CODE', 'RECOVERY', 'SURVEY_TYPE', 'SURVEY_AREA', 'OTHER_FACTORS', 'REMARKS', 'BLEACHING_SEVERITY', 'CORAL_FAMILY', 'CORAL_SPECIES', 'PERCENTAGE_AFFECTED', 'PERCENTAGE_AFFECTED', 'BLEACHING_DURATION', 'MORTALITY_CODE', 'MORTALITY', 'SOURCE', 'REFERENCE_CODE', 'COUNTRY_CODE', 'WATER_TEMPERATURE', 'ID'])


# In[17]:


df.head(10)


# In[20]:


l = []
for code in df['SEVERITY_CODE']:
    if code > 0:
        l.append(1)
    else:
        l.append(0)
df['SEVERITY_CODE'] = l


# In[24]:


df.head(10)


# In[28]:


df['lat'] = df['LAT']


# In[32]:


df['long'] = df['LON']


# In[33]:


df['isDead'] = df['SEVERITY_CODE']


# In[35]:


df = df.drop(columns = ['LAT', 'LON', 'SEVERITY_CODE'])


# In[37]:


len(df)


# In[66]:


pH = []
temp = []
isDive = []
uID = []
index = []

for x in range(len(df)):
    pH.append(round(random.uniform(8.5, 8.9), 2))
    temp.append(round(random.uniform(15.12, 20.00), 2))
    isDive.append(0)
    uID.append(-99999)
    index.append(''.join(random.SystemRandom().choice(string.ascii_uppercase + string.digits) for _ in range(6))
)


# In[67]:


df['pH'] = pH
df['temp'] = temp
df['isDive'] = isDive
df['uID'] = uID
df.index = index


# In[79]:


df[:3]


# In[89]:


json = df[:10].to_json(orient='index')
json


# In[90]:


dic_data = df[:10].to_dict('index')
dic_data


# ### Establishing Firebase Connection and Uploading Data realtime

# In[91]:


fb = firebase.FirebaseApplication('https://coralprotect-4d11c.firebaseio.com/', None)


# In[92]:


j = 3
for i in range(20):
    fb.put('Pi', ''.join(random.SystemRandom().choice(string.ascii_uppercase + string.digits) for _ in range(8)), df[j-3:j].to_dict('index'))
    j = j + 3

