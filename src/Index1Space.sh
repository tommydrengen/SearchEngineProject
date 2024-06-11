echo 'inputfileName\;inputFileSize\;memUsed'  > outputfile.csv
java Index1Space ../files/WestburyLab.wikicorp.201004_100KB.txt >> ../files/outputfile.csv
java Index1Space ../files/WestburyLab.wikicorp.201004_1MB.txt >> ../files/outputfile.csv
java Index2Space ../files/WestburyLab.wikicorp.201004_5MB.txt >> ../files/outputfile.csv
#java Index1Space ../files/WestburyLab.wikicorp.201004_10MB.txt >> ../files/outputfile.csv
#java Index1Space ../files/WestburyLab.wikicorp.201004_20MB.txt >> ../files/outputfile.csv
#java Index1Space ../files/WestburyLab.wikicorp.201004_100MB.txt >> ../files/outputfile.csv
#java Index1Space ../files/WestburyLab.wikicorp.201004_200MB.txt >> ../files/outputfile.csv
#java -Xmx12g Index1Space ../files/WestburyLab.wikicorp.201004_400MB.txt >> ../files/outputfile.csv

echo 'inputfileName\;inputFileSize\;memUsed'  > outputfile.csv
java Index2Space ../files/WestburyLab.wikicorp.201004_100KB.txt >> ../files/outputfile.csv
java Index2Space ../files/WestburyLab.wikicorp.201004_1MB.txt >> ../files/outputfile.csv
java Index2Space ../files/WestburyLab.wikicorp.201004_5MB.txt >> ../files/outputfile.csv
#java Index2Space ../files/WestburyLab.wikicorp.201004_10MB.txt >> ../files/outputfile.csv
#java Index2Space ../files/WestburyLab.wikicorp.201004_20MB.txt >> ../files/outputfile.csv
#java Index2Space ../files/WestburyLab.wikicorp.201004_100MB.txt >> ../files/outputfile.csv
#java Index2Space ../files/WestburyLab.wikicorp.201004_200MB.txt >> ../files/outputfile.csv
#java -Xmx12g Index2Space ../files/WestburyLab.wikicorp.201004_400MB.txt >> ../files/outputfile.csv

echo 'inputfileName\;inputFileSize\;memUsed'  > outputfile.csv
java Index3Space ../files/WestburyLab.wikicorp.201004_100KB.txt >> outputfile.csv
java Index3Space ../files/WestburyLab.wikicorp.201004_1MB.txt >> outputfile.csv
java Index3Space ../files/WestburyLab.wikicorp.201004_2MB.txt >> outputfile.csv
java Index3Space ../files/WestburyLab.wikicorp.201004_5MB.txt >> outputfile.csv
#java Index3Space ../files/WestburyLab.wikicorp.201004_10MB.txt >> outputfile.csv
#java Index3Space ../files/WestburyLab.wikicorp.201004_20MB.txt >> outputfile.csv
#java Index3Space ../files/WestburyLab.wikicorp.201004_100MB.txt >> outputfile.csv
#java -Xmx12g Index3Space ../files/WestburyLab.wikicorp.201004_200MB.txt >> outputfile.csv
#java -Xmx12g Index3Space ../files/WestburyLab.wikicorp.201004_400MB.txt >> ../files/outputfile.csv


echo 'inputfileName\;inputFileSize\;memUsed'  > outputfile.csv
java Index4Space ../files/WestburyLab.wikicorp.201004_100KB.txt >> ../files/outputfile.csv
java Index4Space ../files/WestburyLab.wikicorp.201004_1MB.txt >> ../files/outputfile.csv
java Index4Space ../files/WestburyLab.wikicorp.201004_2MB.txt >> ../files/outputfile.csv
java Index4Space ../files/WestburyLab.wikicorp.201004_5MB.txt >> ../files/outputfile.csv
#java Index4Space ../files/WestburyLab.wikicorp.201004_20MB.txt >> ../files/outputfile.csv
#java Index4Space ../files/WestburyLab.wikicorp.201004_100MB.txt >> ../files/outputfile.csv
#java -Xmx12g Index4Space ../files/WestburyLab.wikicorp.201004_200MB.txt >> outputfile.csv
#java -Xmx12g Index4Space ../files/WestburyLab.wikicorp.201004_400MB.txt >> ../files/outputfile.csv

