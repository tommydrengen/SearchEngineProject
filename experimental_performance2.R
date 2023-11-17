########## Ikke-logartmisk skala ###################

# Define the file sizes and preprocessing times for each index
filesizeMB = c(0.100, 1.000, 2.000, 5.000)  # The common file sizes for all indices
i1preprocessingTimeMs = c(183, 1402, 2737, 6409)
i2preprocessingTimeMs = c(117, 1365, 2498, 6067)
i3preprocessingTimeMs = c(749, 30084, 87228, 409458)
i4preprocessingTimeMs = c(775, 28445, 86274, 410083)

# Find the range for the y-axis that fits all preprocessing times
y_range <- range(c(i1preprocessingTimeMs, i2preprocessingTimeMs, i3preprocessingTimeMs, i4preprocessingTimeMs))

# Plot the preprocessing times for Index1
plot(filesizeMB, i1preprocessingTimeMs, type = "p", col = "red", xlab = "File size (MB)", ylab = "Preprocessing Time (ms)", main = "Preprocessing Times", ylim = y_range, pch = 16)

# Add the preprocessing times for Index2 using points
points(filesizeMB, i2preprocessingTimeMs, col = "blue", pch = 17)

# Add the preprocessing times for Index3 using points
points(filesizeMB, i3preprocessingTimeMs, col = "green", pch = 18)

# Add the preprocessing times for Index4 using points
points(filesizeMB, i4preprocessingTimeMs, col = "purple", pch = 19)

# Add a legend to the plot to label the points
legend("topright", legend = c("Index1", "Index2", "Index3", "Index4"), col = c("red", "blue", "green", "purple"), pch = 16:19)

################ logaritmisk skala ######################

# Define the file sizes and preprocessing times for each index
filesizeMB = c(0.100, 1.000, 2.000, 5.000)  # The common file sizes for all indices
i1preprocessingTimeMs = c(183, 1402, 2737, 6409)
i2preprocessingTimeMs = c(117, 1365, 2498, 6067)
i3preprocessingTimeMs = c(749, 30084, 87228, 409458)
i4preprocessingTimeMs = c(775, 28445, 86274, 410083)

# Determine an appropriate y-axis range that can fit all preprocessing times on a log scale
y_min <- min(c(i1preprocessingTimeMs, i2preprocessingTimeMs, i3preprocessingTimeMs, i4preprocessingTimeMs))
y_max <- max(c(i1preprocessingTimeMs, i2preprocessingTimeMs, i3preprocessingTimeMs, i4preprocessingTimeMs))

# Plot the preprocessing times for Index1 using a log scale for the y-axis
plot(filesizeMB, i1preprocessingTimeMs, type = "p", col = "red", xlab = "File size (MB)", ylab = "Preprocessing Time (ms, log scale)", main = "Preprocessing Times", ylim = c(y_min, y_max), pch = 16, log = "y")

# Add the preprocessing times for Index2 using points
points(filesizeMB, i2preprocessingTimeMs, col = "blue", pch = 17)

# Add the preprocessing times for Index3 using points
points(filesizeMB, i3preprocessingTimeMs, col = "green", pch = 18)

# Add the preprocessing times for Index4 using points
points(filesizeMB, i4preprocessingTimeMs, col = "purple", pch = 19)

# Add a legend to the plot to label the points
legend("topright", legend = c("Index1", "Index2", "Index3", "Index4"), col = c("red", "blue", "green", "purple"), pch = 16:19)

# Define the file sizes and search times for each index
filesizeMB = c(0.100, 1.000, 2.000, 5.000, 10.000, 20.000, 50.000, 100.000, 200.000)
searchTimeMs_Index1 = c(10, 11, 13, 16, 27, 39, 70, 115, 194)
searchTimeMs_Index2 = c(20, 25, 29, 35, 41, 48, 82, 130, 206)
searchTimeMs_Index3 = c(11, 6, 9, 14, 25)  # first four file sizes
searchTimeMs_Index4 = c(0, 0, 0, 0, 0)  # first five file sizes

# Find the range for the y-axis that fits all search times
y_range <- range(c(searchTimeMs_Index1, searchTimeMs_Index2, searchTimeMs_Index3, searchTimeMs_Index4), na.rm = TRUE)

# Plot the search times for Index1
plot(filesizeMB, searchTimeMs_Index1, type = "p", col = "red", xlab = "File size (MB)", ylab = "Search Time (ms)", main = "Search Times", ylim = y_range, pch = 16)

# Add the search times for Index2 using points
points(filesizeMB, searchTimeMs_Index2, col = "blue", pch = 17)

# Add the search times for Index3 using points. Only plot the points for which we have data.
points(filesizeMB[1:length(searchTimeMs_Index3)], searchTimeMs_Index3, col = "green", pch = 18)

# Add the search times for Index4 using points. Only plot the points for which we have data.
points(filesizeMB[1:length(searchTimeMs_Index4)], searchTimeMs_Index4, col = "purple", pch = 19)

# Add a legend to the plot to label the points
legend("topright", legend = c("Index1", "Index2", "Index3", "Index4"), col = c("red", "blue", "green", "purple"), pch = 16:19)

# Define the file sizes and space usage for each index
filesizeMB = c(0.100, 1.000, 2.000, 5.000, 10.000, 20.000, 50.000, 100.000, 200.000)
spaceMB_Index1 = c(8.00, 31.8, 44.9, 103, 133, 288, 798, 1588, 2961)
spaceMB_Index2 = c(8.00, 32.0, 42.6, 101, 134, 287, 685, 1424, 3128)
# The space usage for Index3 and Index4 is assumed to be provided for the first five file sizes
spaceMB_Index3 = c(48, 315, 1097, 806, 754)
spaceMB_Index4 = c(412, 553, 944, 545)  # Assuming these are correct for the first four file sizes

# Find the range for the y-axis that fits all space usages
y_range <- range(c(spaceMB_Index1, spaceMB_Index2, spaceMB_Index3, spaceMB_Index4), na.rm = TRUE)

# Plot the space usage for Index1
plot(filesizeMB, spaceMB_Index1, type = "p", col = "red", xlab = "File size (MB)", ylab = "Space (MB)", main = "Space Usage", ylim = y_range, pch = 16)

# Add the space usage for Index2 using points
points(filesizeMB, spaceMB_Index2, type = "p", col = "blue", pch = 17)

# Add the space usage for Index3 using points. Only plot the points for which we have data.
points(filesizeMB[1:length(spaceMB_Index3)], spaceMB_Index3, type = "p", col = "green", pch = 18)

# Add the space usage for Index4 using points. Only plot the points for which we have data.
points(filesizeMB[1:length(spaceMB_Index4)], spaceMB_Index4, type = "p", col = "purple", pch = 19)

# Add a legend to the plot to label the points
legend("topright", legend = c("Index1", "Index2", "Index3", "Index4"), col = c("red", "blue", "green", "purple"), pch = 16:19)


#search time as a function of word length
wordLength = c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 31)
time_ms_Index1 = c(2, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0)#2Mb

wordLength = c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 31)
time_ms_Index2 = c(28, 34, 19, 6, 8, 11, 11, 13, 8, 4, 11, 13, 11, 6, 13, 12)#2Mb

wordLength = c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 31)
time_ms_Index3 = c(15, 4, 3, 3, 2, 2, 2, 1, 0, 0, 1, 1, 0, 0, 0, 0) #2MB

wordLength = c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 31)
time_ms_Index4 = c(0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1)#2MB

y_range <- range(c(time_ms_Index1, time_ms_Index2, time_ms_Index3, time_ms_Index4), na.rm = TRUE)


plot(wordLength, time_ms_Index1, type = "p", col = "red", xlab = "word length", ylab = "Search Time (ms)", main = "Time", ylim = y_range, pch = 16)

# Add the time for Index2 using points
points(wordLength, time_ms_index2, type = "p", col = "blue", pch = 17)

# Add the time for Index3 using points. Only plot the points for which we have data.
points(wordLength[1:length(time_ms_index3)], time_ms_index3, type = "p", col = "green", pch = 18)

# Add the time for Index4 using points. Only plot the points for which we have data.
points(wordLength[1:length(time_ms_index)], time_ms_index4, type = "p", col = "purple", pch = 19)

# Add a legend to the plot to label the points
legend("topright", legend = c("Index1", "Index2", "Index3", "Index4"), col = c("red", "blue", "green", "purple"), pch = 16:19)

#2MB word length, occurences

wordlengths = c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 30, 31,32,34,35,43,45,88)
occurences = c(61, 401, 1323, 2614, 4017, 4286, 4230, 3819, 3195, 2336, 1607, 1077, 683, 437, 218, 112, 67, 44, 24, 18, 9, 6, 3,3,2,1,1,3,3,1, 2,3,1,1,1,1)
plot(wordlengths, occurences)
mean(wordLength)
sd(wordlengths)

occurences = c(replicate(61,1), replicate(401,2), replicate(1323, 3), replicate(2614, 4), replicate(4017, 5), replicate(4286, 6), replicate(4230,7), replicate(3819, 8), replicate(3195, 9), replicate(2336, 10), replicate(1607,11), replicate(1077, 12), replicate(683,13), replicate(437,14), replicate(218,15), replicate(112,16), replicate(67,17), replicate(44,18), replicate(24,19), replicate(18,20), replicate(9,21), replicate(6,22), replicate(3,23),replicate(3,24),replicate(2,25),replicate(1,26), replicate(1,27),replicate(3,28),replicate(3,30),replicate(1,31), replicate(2,32),replicate(2,34),replicate(1, 35),replicate(1,43),replicate(1,45),replicate(1,88))
mean(occurences)
sd(occurences)

wordlengths = c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 30, 31,32,34,35,43,45,88)
occurences = c(61, 401, 1323, 2614, 4017, 4286, 4230, 3819, 3195, 2336, 1607, 1077, 683, 437, 218, 112, 67, 44, 24, 18, 9, 6, 3,3,2,1,1,3,3,1, 2,3,1,1,1,1)
plot(wordlengths, occurences)
mean(wordLength)
sd(wordlengths)
occurences = c(replicate(15,1),
               replicate(62,2),
               replicate(144, 3),
               replicate(303, 4),
               replicate(337, 5),
               replicate(346, 6),
               replicate(317,7),
               replicate(318, 8),
               replicate(271, 9),
               replicate(218, 10),
               replicate(124,11),
               replicate(12, 1077),
               replicate(13,683),
               replicate(14,437),
               replicate(15,218),
               replicate(16,112),
               replicate(17,67),
               replicate(18,44),
               replicate(19,24),
               replicate(20,18),
               replicate(21,9),
               replicate(22,6),
               replicate(23,3),
               replicate(24,3),
               replicate(25,2),
               replicate(26,1),
               replicate(27,1),
               replicate(28,3),
               replicate(30,3),
               replicate(31,1),
               replicate(32,2),
               replicate(34,3),
               replicate(35,1),
               replicate(43,1),
               replicate(45,1),
               replicate(88,1))

#100kb
# Your data
occurrences <- c(replicate(1, 15),
                 replicate(2, 62),
                 replicate(3, 144),
                 replicate(4, 303),
                 replicate(5, 337),
                 replicate(6, 346),
                 replicate(7, 317),
                 replicate(8, 318),
                 replicate(9, 271),
                 replicate(10, 218),
                 replicate(11, 124),
                 replicate(12, 83),
                 replicate(13, 46),
                 replicate(14, 21),
                 replicate(15, 11),
                 replicate(16, 9),
                 replicate(17, 7),
                 replicate(18, 6),
                 replicate(19, 0),
                 replicate(20, 0),
                 replicate(21, 1),
                 replicate(22, 1))

# Create a bar plot with axis labels and title
barplot(occurrences, col = "skyblue", 
        main = "Word Length Distribution",
        xlab = "Word Length",
        ylab = "Occurrences")

# Add custom labels to the x-axis

#search time as a function of word position 5MB file
wordposition = c(1, 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000, 101000, 101436)
# 'Anarchism.', 'politics;', 'prophetic', '"That's', 'Hotak,', 'Studying', 'near-eastern', 'clinical,', '"polluting', '#PIZZA,', 'unwarranted', 'plating', 'Brontotheria.'
index1SearchTimeMs = c( 1, 3, 3, 2, 4, 3, 4, 4, 6, 6, 13, 11, 10)
index2SearchTimeMs = c( 48, 23, 11, 12, 13, 14, 11, 5, 10, 11, 14, 12, 14)
index3SearchTimeMs = c(13, 5, 5, 9, 5, 6, 9, 9, 12, 12, 9, 13, 12)
# 'Anarchism', 'politics;', 'prophetic', '"That's', 'Hotak,', 'Studying', 'near-eastern', 'clinical,', '"polluting', '#PIZZA,', 'unwarranted', 'plating', 'Brontotheria.'
index4SearchTimeMs = c(0, 6, 9, 0, 5, 10, 11, 10, 11, 13, 15, 12, 10)

y_range <- range(c(index1SearchTimeMs, index2SearchTimeMs, index3SearchTimeMs, index4SearchTimeMs), na.rm = TRUE)


plot(wordposition, index1SearchTimeMs, type = "p", col = "red", xlab = "word position", ylab = "Search Time (ms)", main = "Time", ylim = y_range, pch = 16)

# Add the time for Index2 using points
points(wordposition, index2SearchTimeMs, type = "p", col = "blue", pch = 17)

# Add the time for Index3 using points. Only plot the points for which we have data.
points(wordposition, index3SearchTimeMs, type = "p", col = "green", pch = 18)

# Add the time for Index4 using points. Only plot the points for which we have data.
points(wordposition, index4SearchTimeMs, type = "p", col = "purple", pch = 19)

# Add a legend to the plot to label the points
legend("topright", legend = c("Index1", "Index2", "Index3", "Index4"), col = c("red", "blue", "green", "purple"), pch = 16:19)




#search time as a function of word length

wordLength = c(1,2,3,4,5,6,7,8,9,10,11)
searchTimeMsWordLength = c(0,0)
i1searchTimeMsWordLength = c()
i2searchTimeMsWordLength = c()
i3searchTimeMsWordLength = c()
i4searchTimeMsWordLength = c()



