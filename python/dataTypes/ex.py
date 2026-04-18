# s = "Rahul"

# print(s[0])
# print(s[-1])

# print(s[0:3])
# print(s[:3])

# print(s[::-1])

# s = 'X'+s[1:]

# print(s)




# s = "Rudra"
# print(s.upper())
# print(s.find("u"))
# print(s.replace('a', ""))
# words = s.split()
# print(words)
# print("".join(words))

# name = input("Enter your name-")
# marks = int(input("Enter your mark-"))
# print(f"My name is {name} and I scored {marks} marks")

# print("Hello \n Rudra")





# nums = [1, 2, 3, 4, 5]
# print(nums[1])
# print(nums[-1])

# # for i in range(-1, -6, -1):
# #     print(nums[i])


# i = 0
# j = len(list)-1

# while i<j:
#     temp = nums[i]
#     nums[i] = nums[j]
#     nums[j] = temp
#     i += 1
#     j -= 1

# print(nums)


# nums[1] = 420

# print(nums)










# nums = []
# nums.append(10)
# nums.append(20)
# nums.append(30)
# nums.append(40)
# print(nums)

# nums.insert(2, 300)
# print(nums)

# # nums.remove(-1)
# nums.pop()
# print(nums)

# nums.remove(300)
# print(nums)










# nums1 = [10, 20, 30]
# nums2 = nums1.copy()
# nums1[1] = 200
# print(nums1)
# print(nums2)

# squares = [x*x for x in nums1]

# even = [x for x in range(20) if x%2 == 0]

# print(squares)
# print(even)








# t = (1, 2, 3)

# print(t[0])
# print(t[-1])

# # t[0] = 10

# # Traceback (most recent call last):
# #   File "/home/rudra/LABS/playZone/python/dataTypes/ex.py", line 121, in <module>
# #     t[0] = 10
# #     ~^^^
# # TypeError: 'tuple' object does not support item assignment


# a, b, c = t
# print(a, b, c)








s = {1,1,2,2,3,4,}
print(s)

s.add(12)
print(s)
s.remove(3)
print(s)




s1 = {1,2,3,}
s2 = {2,3,4,}

print(f"Union-{s1 | s2}")
print(f"Intersection-{s1 & s2}")