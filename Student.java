class Student  implements Comparable<Student>{
     String name;
     Integer marks;

     Student(String name,Integer marks){
          this.name = name;
          this.marks = marks;
     }

     public int compareTo(Student o) {
          return this.marks.compareTo(o.marks);
     }


}