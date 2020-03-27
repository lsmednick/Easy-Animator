
                             *** Overview of OODAnimator ***

** Construction of Hierarchy **

    AnimatorModel (Interface)
                ↑
    AnimatorModelImpl (class for implementing Interface)


    IShape (Interface)
                ↑
    AbstractShape (abstract class that implements IShape)
                ↑
    Oval, Rectangle, Triangle (concrete classes that extend AbstractShape)


    ITransform (Interface)
                ↑
    AbstractTransform (abstract class that implements ITransform)
                ↑
    ChangeColor, ChangeScale, ChangePos (concrete classes that extend AbstractTransformation)


** Description of Interfaces, Abstract Classes, and Concrete Classes **

*   Interfaces :
- AnimatorModel -- An interface for the model, it contains methods to add/store shapes, change a
shape's position, color, and scale, and a method to get the current state of an
animation.

- IShape -- An interface that contains methods to create objects that represents
a 2-D geometric shape (e.g. Oval, Rectangle, Triangle) in the animation.

- ITransform -- An interface that supports creating ITransform objects which record IShape object
transformations (e.g. changes color, position or scale). The ITransform objects for
the animation are stored in the AnimatorModelImpl within a List. The interface
contains getters for the shape ID  (unique identifier of each IShape), the start
time of the transformation and the end time of the transformation.


*   Abstract Classes/Class that Implement an Interface :
- AnimatorModelImpl -- Is a class that implements interface AnimatorModel. This class holds a
Map which contains a list of all the shapes in the animation. The Map's key
is a String ID and the value is a IShape (Oval, Rectangle, Triangle).
Separately, this class also stores a List of transformations (ChangeColor,
ChangePosition, ChangeScale) that occur within the animation.

- AbstractShape -- Is a class that implements IShape methods, which contains getters and setters
for a shape's fields. Included are getters for the position each shape
(x,y coordinates),color (r,g,b values), height, width, start time
(shape's appearance in an animation), end time (when a shape disappears in the
animation), and name of a given shape. Currently three concrete classes (Oval,
Rectangle, and Triangle) extend AbstractShape.

- AbstractTransform -- Is a class that implements ITransform and the Comparable interface which
will allow transformation to be sorted in accordance to the start/end times
within an animation. It also contains a constructor with parameters for a
shape ID, start time and end time of a transformation.


*   Concrete Classes :
- Oval, Rectangle, Triangle -- These 3 concrete classes extend AbstractShape each has a toString
method to describe the shape's fields and a constructor that calls the super class AbstractShape.

- ChangeColor, ChangeScale, ChangePos -- These classes extend the abstract class AbstractTransform.
Each of the 3 concrete classes has a toString that details the transformation. Each class's
constructor instantiates fields for a shape's initial values and the values it should
become. For example, ChangePos will change the position of an object based on its x,y
coordinates -- the constructor will contain the starting position (fromX, fromY) and ending
positions (toX, toY). Additionally the constructor calls the super class AbstractShape to
instantiate the shape ID, start/end time of a transformation.


* Enums :
- ShapeType -- This class is a enum representing the various types of shapes supported by this
animator (Oval, Rectangle, Triangle).

