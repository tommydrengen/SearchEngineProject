# Experimental performance

# Index1
# Preprocessing time
filesizeMB = c(0.100, 1.000, 2.000, 5.000, 10.000, 20.000, 50.000, 100.000, 200.000)
length(filesizeMB)
preprocessingTimeMs = c(183, 1402, 2737, 6409, 12594, 25103, 62620, 126368, 253770)
plot(x = filesizeMB, y = preprocessingTimeMs, xlab = 'File sz (MB)', ylab = 'Index1 Preprocessing Time (ms)')
# Search time
filesizeMB = c(0.100, 1.000, 2.000, 5.000, 10.000, 20.000, 50.000, 100.000, 200.000) # 4 Mb heap space error
length(filesizeMB)
searchTimeMs = c(10, 11, 13, 16, 27, 39, 70, 115, 194)
plot(x = filesizeMB, y = searchTimeMs, xlab = 'File sz (MB)', ylab = 'Index1 Search Time (ms)')

# Index1
# Space
filesizeMB = c(0.100, 1.000, 2.000, 5.000, 10.000, 20.000, 50.000, 100.000, 200.000)
spaceMB = c(8.00, 31.8, 44.9, 103, 133, 288, 798, 1588, 2961)
length(filesizeMB)
plot(x = filesizeMB, y = spaceMB, xlab = 'File sz (MB)', ylab = 'Index1 Space (MB)')



# Index2
# Preprocessing time
filesizeMB = c(0.100, 1.00, 2.00, 5.00, 10.0, 20.0, 50.0, 100, 200, 400)
length(filesizeMB)
preprocessingTimeMs = c(117, 1365, 2498, 6067, 12317, 24565, 61449, 123765, 245897, 499945)
length(preprocessingTimeMs)
plot(x = filesizeMB, y = preprocessingTimeMs, xlab = 'File sz (MB)', ylab = 'Index2 Preprocessing Time (ms)')
# Search time
filesizeMB = c(0.100, 1.00, 2.00, 5.00, 10.0, 20.0, 50.0, 100.0, 200.0)
length(filesizeMB)
searchTimeMs = c(20, 25, 29, 35, 41, 48, 82, 130, 206)
plot(x = filesizeKB, y = searchTimeMs, xlab = 'File sz (MB)', ylab = 'Index2 Search Time (ms)')


#Index3
# Preprocessing time
filesizeMB = c(0.100, 1.00, 2.00, 5.00)#, 20.000, 50.000, 100.000, 200.000, 400.000)
length(filesizeMB)
preprocessingTimeMs = c(749, 30084, 87228, 409458)
length(preprocessingTimeMs)
plot(x = filesizeMB, y = preprocessingTimeMs, xlab = 'File sz (MB)', ylab = 'Index3 Preprocessing Time (ms)')
# Search time
filesizeMB = c(0.100, 1.00, 2.00, 5.00) #, 10.000, 20.000, 50.000, 100.000, 200.000, 400.000)
length(filesizeMB)
searchTimeMs = c(11, 6, 9, 14)
plot(x = filesizeKB, y = preprocessingTimeMs, xlab = 'File sz (MB)', ylab = 'Index3 Search Time (ms)')


#Index4
# Preprocessing time
filesizeMB = c(0.100, 1.000, 2.000, 5.000) #, 10.000, 20.000, 50.000, 100.000, 200.000, 400.000)
length(filesizeMB)
preprocessingTimeMs = c(775, 28445, 86274, 410083)
length(preprocessingTimeMs)
plot(x = filesizeMB, y = preprocessingTimeMs, xlab = 'File sz (MB)', ylab = 'Index4 Preprocessing Time (ms)')
# Search time
filesizeMB = c(0.100, 1.00, 2.00, 5.00, 10.0) #, 20.0, 50.0, 100, 200, 400)
length(filesizeMB)
searchTimeMs = c(0, 0, 0, 0, 0)
plot(x = filesizeKB, y = preprocessingTimeMs, xlab = 'File sz (MB)', ylab = 'Index4 Search Time (ms)')
