'''
Created on Nov 7, 2013

@author: barbz
'''

import urllib
import zipfile
import os

slick_url = "http://slick.ninjacave.com/slick.zip"
lwjgl_url = "http://downloads.sourceforge.net/project/java-game-lib/Official%20Releases/LWJGL%202.9.0/lwjgl-2.9.0.zip?r=http%3A%2F%2Fsourceforge.net%2Fprojects%2Fjava-game-lib%2Ffiles%2FOfficial%2520Releases%2FLWJGL%25202.9.0%2Flwjgl-2.9.0.zip"
git_url = "https://msysgit.googlecode.com/files/Git-1.8.4-preview20130916.exe"
print("Downloading Slick2d...")
urllib.urlretrieve(slick_url, "slick.zip")
print("Downloading LWJGL...")
urllib.urlretrieve(lwjgl_url, "lwjgl-2.9.0.zip")
print("Extracting Slick2d...")
slickfile = zipfile.ZipFile("slick.zip", "a")
slickfile.extractall("lib/slick2d")
print("Extracting LWJGL...")
lwjglfile = zipfile.ZipFile("lwjgl-2.9.0.zip", "a")
lwjglfile.extractall("lib")


print("Downloading Git...")
urllib.urlretrieve(git_url, "Git-1.8.4-preview20130916.exe")
print("The EGit Update Site is: http://download.eclipse.org/egit/updates")

os.remove("slick.zip")
os.remove("lwjgl-2.9.0.zip")