# CoralProtect
### What does CoralProtect do?

Deploys slave cameras for detection that are radially located and are positioned in a specified and constant distance from the Raspberry   Pi device that uses image classifiers to detect whether any slave camera is transmitting video feed of dead or bleached coral reefs. 

The model will be running on the Raspberry Pi using a Convolutional Neural Network that runs on TensorFlow Lite and then fires the      labels(0 or 1) to the cloud. 
The mobile application provides two main features:
 - Ability to help clean litter by diving and earning credits that can be monetarized by government or NGO funds
 - Ability to report illicit activities by tourists or locals, for instance, selling shells or illicit fishing

### What is included in the product?

 - RaspberryPi Master Modules with TensorFlowLite CNN(Convolutional Neural Networks) model
 - NodeMCU Slave Modules with:
 - - Camera Feed 
 - - Temperature Sensor
 - - pH Sensor 
 - FireBase Realtime Database
 - Mobile Application 
 
### System Architechure
![FlowChart](https://github.com/shubham0008/CoralProtect/blob/master/readme/Flowchart.jpg)

### Technologies and Dependencies needed to run CoralProtect

* [TensorFlow] - An open source machine learning framework for everyone
* [GoogleMapsAPI] - Build customized, agile experiences that bring the real world to your users with static and dynamic maps
* [FireBase RealTime Database] - Google's mobile platform for quickly developing high-quality apps
* [Google Cloud Platform] - A suite of cloud computing services that runs on the same infrastructure that Google
* [Docker] - A computer program that performs operating-system-level virtualization, also known as "containerization"

[TensorFlow]: <https://www.tensorflow.org>
[GoogleMapsAPI]: <https://developers.google.com/maps>
[FireBase RealTime Database]: <https://firebase.google.com>
[Google Cloud Platform]: <https://cloud.google.com>
[Docker]: <https://www.docker.com>
