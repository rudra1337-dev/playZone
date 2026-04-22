print("Welcome to Advance functionality and Internal Concepts");


# square = lambda x: x*x
# print(square(10))


# isEven = lambda n: n%2 == 0
# print(isEven(4))
# print(isEven(5))


# max_val = lambda a, b: a if a>b else b
# print(max_val(2, 5))
# print(max_val(8, 5))







# nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
# res = list(map(lambda x: x*x*x, nums))
# print(res)

# res1 = list(filter(lambda x: x>5, nums))
# print(res1)

# from functools import reduce

# res2 = reduce(lambda x, y: x*y, nums)
# print(res2)







# nums = [1,2,3,4,5]
# for i, x in enumerate(nums):
#     print(i,x)



# marks = [20, 30, 55]
# names = ["Rahul", "Rudra", "Muna"]

# res = list(zip(names, marks))
# print(res)

# print(sorted(marks, reverse=True))

# print(list(reversed(names)))







# nums = [1, 2, 3, 4, 4, 5]
# squares = [x*x for x in nums]
# print(squares)

# odd = [x for x in nums if x%2 != 0]
# print(odd)

# print(set(x for x in nums))
# # print(dict(x: (x*x*x) for x in nums))
# d = {x: (x*x*x) for x in nums}
# print(d)





s = "154"

print(int(s))
print(float(s))

nums = [1, 2, 2, 3, 4, 5]

st = set(nums)
print(st)

lst = list(st)
print(lst)

lst1 = list(s)
print(lst1)

print("".join(lst1))