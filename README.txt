
                             *** Overview of OODAnimator ***

** Construction of Hierarchy **

    cs5004.animator.model.AnimatorModel (Interface)
                ↑
    cs5004.animator.model.AnimatorModelImpl (class for implementing Interface)


    cs5004.animator.model.IShape (Interface)
                ↑
    cs5004.animator.model.AbstractShape (abstract class that implements cs5004.animator.model.IShape)
                ↑
    cs5004.animator.model.Oval, cs5004.animator.model.Rectangle, cs5004.animator.model.Triangle (concrete classes that extend cs5004.animator.model.AbstractShape)


    cs5004.animator.model.ITransform (Interface)
                ↑
    cs5004.animator.model.AbstractTransform (abstract class that implements cs5004.animator.model.ITransform)
                ↑
    cs5004.animator.model.ChangeColor, cs5004.animator.model.ChangeScale, cs5004.animator.model.ChangePos (concrete classes that extend AbstractTransformation)


** Description of Interfaces, Abstract Classes, and Concrete Classes **

*   Interfaces :
- cs5004.animator.model.AnimatorModel -- An interface for the model, it contains methods to add/store shapes, change a
shape's position, color, and scale, and a method to get the current state of an
animation.

- cs5004.animator.model.IShape -- An interface that contains methods to create objects that represents
a 2-D geometric shape (e.g. cs5004.animator.model.Oval, cs5004.animator.model.Rectangle, cs5004.animator.model.Triangle) in the animation.

- cs5004.animator.model.ITransform -- An interface that supports creating cs5004.animator.model.ITransform objects which record cs5004.animator.model.IShape object
transformations (e.g. changes color, position or scale). The cs5004.animator.model.ITransform objects for
the animation are stored in the cs5004.animator.model.AnimatorModelImpl within a List. The interface
contains getters for the shape ID  (unique identifier of each cs5004.animator.model.IShape), the start
time of the transformation and the end time of the transformation.


*   Abstract Classes/Class that Implement an Interface :
- cs5004.animator.model.AnimatorModelImpl -- Is a class that implements interface cs5004.animator.model.AnimatorModel. This class holds a
Map which contains a list of all the shapes in the animation. The Map's key
is a String ID and the value is a cs5004.animator.model.IShape (cs5004.animator.model.Oval, cs5004.animator.model.Rectangle, cs5004.animator.model.Triangle).
Separately, this class also stores a List of transformations (cs5004.animator.model.ChangeColor,
ChangePosition, cs5004.animator.model.ChangeScale) that occur within the animation.

- cs5004.animator.model.AbstractShape -- Is a class that implements cs5004.animator.model.IShape methods, which contains getters and setters
for a shape's fields. Included are getters for the position each shape
(x,y coordinates),color (r,g,b values), height, width, start time
(shape's appearance in an animation), end time (when a shape disappears in the
animation), and name of a given shape. Currently three concrete classes (cs5004.animator.model.Oval,
cs5004.animator.model.Rectangle, and cs5004.animator.model.Triangle) extend cs5004.animator.model.AbstractShape.

- cs5004.animator.model.AbstractTransform -- Is a class that implements cs5004.animator.model.ITransform and the Comparable interface which
will allow transformation to be sorted in accordance to the start/end times
within an animation. It also contains a constructor with parameters for a
shape ID, start time and end time of a transformation.


*   Concrete Classes :
- cs5004.animator.model.Oval, cs5004.animator.model.Rectangle, cs5004.animator.model.Triangle -- These 3 concrete classes extend cs5004.animator.model.AbstractShape each has a toString
method to describe the shape's fields and a constructor that calls the super class cs5004.animator.model.AbstractShape.

- cs5004.animator.model.ChangeColor, cs5004.animator.model.ChangeScale, cs5004.animator.model.ChangePos -- These classes extend the abstract class cs5004.animator.model.AbstractTransform.
Each of the 3 concrete classes has a toString that details the transformation. Each class's
constructor instantiates fields for a shape's initial values and the values it should
become. For example, cs5004.animator.model.ChangePos will change the position of an object based on its x,y
coordinates -- the constructor will contain the starting position (fromX, fromY) and ending
positions (toX, toY). Additionally the constructor calls the super class cs5004.animator.model.AbstractShape to
instantiate the shape ID, start/end time of a transformation.


* Enums :
- cs5004.animator.model.ShapeType -- This class is a enum representing the various types of shapes supported by this
animator (cs5004.animator.model.Oval, cs5004.animator.model.Rectangle, cs5004.animator.model.Triangle).

