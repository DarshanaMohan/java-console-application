public class Notes implements Cloneable
{
        private  int  notes;// Static field to store the denomination of the note
        private  int count;// Static field to store the count of notes available for this denomination
        public Notes(int notes,int count)// Constructor to initialize the denomination and count of notes
        {
            this.notes=notes;// Assigning the provided denomination to the static field 'notes'
            this.count=count;// Assigning the provided count to the static field 'count'
        }


        public int getNotes()// Static method to get the denomination of the notes
        {
            return notes;//Returning the static field 'notes'
        }

    public void setNotes(int notes) {
        this.notes = notes;
    }

        public int getCount()// Static method to get the count of notes available for the given denomination
        {
            return count;// Returning the static field 'count'
        }


        public void setCount(int count) // Static method to set the count of notes
        {
            this.count = count;
        }

        public Notes clone() throws CloneNotSupportedException{// Method to clone a Notes object
            // Calling the clone method of the Object class to create a copy of the Notes object
            return (Notes) super.clone();
        }
}

