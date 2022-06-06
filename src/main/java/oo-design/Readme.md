## Step 1: Handle Ambiguity

* Object-oriented design (OOD) questions are often intentionally vague in order to test whether you'll make assumptions
  or if you'll ask clarifying questions.
* When being asked an object-oriented design question, you should inquire who is going to use it and how they are going
  to use it. Depending on the question, you may even want to go through the "six Ws": who, what, where, when, how, why.
* For example, suppose you were asked to describe the object-oriented design for a coffee maker. This seems
  straightforward enough, right? Not quite. Your coffee maker might be an industrial machine designed to be used in a
  massive restaurant servicing hundreds of customers per hour and making ten different kinds of coffee products. Or it
  might be a very simple machine, designed to be used by the elderly for just simple black coffee. These use cases will
  significantly impact your design.

## Step 2: Define the Core Objects

* Now that we understand what we're designing, we should consider what the "core objects" in a system are. For example,
  suppose we are asked to do the object-oriented design for a restaurant. Our core objects might be things like Table,
  Guest, Party, Order, Meal, Employee, Server, and Host.

## Step 3: Analyze Relationships

* Having more or less decided on our core objects, we now want to analyze the relationships between the objects. Which
  objects are members of which other objects? Do any objects inherit from any others? Are relationships many-to-many or
  one-to-many?

## Step 4: Investigate Actions