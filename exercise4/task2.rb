require 'continuation'

def factorial (i)
#__blank1__
(cc, f, i) = callcc {|cc| [cc, 1, i]} #fragment 6
#__blank2__
if (i == 0) then
#__blank3__
return f
else
#__blank4__
cc.call(cc, i * f, i - 1) #fragment 3
end
#__blank5__
end

def fibonacci (n)
#__blank6__
cc, f, p, i = callcc {|cc| [cc, 1, 0, 0]}  #fragment 5
if i < n then
#__blank7__
cc.call(cc, f + p, f, i + 1) #fragment 2
else
# __blank__8
end
# __blank__9
return f
end

puts fibonacci(10).inspect
puts factorial(6).inspect