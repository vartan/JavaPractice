
class BinaryTreeNode<T> {

    T data;
    private BinaryTreeNode<T> parent, left, right;
    boolean visited = false;
    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
    public void clearVisited() {
        this.visited = false;
        if(this.left!=null)this.left.clearVisited();
        if(this.right!=null)this.left.clearVisited();
    }
    public void setLeft(BinaryTreeNode<T> n) {
        this.left = n;
        if(n!=null)
            n.parent = this;
    }
    public void setRight(BinaryTreeNode<T> n) {
        this.right = n;
        if(n!=null)
            n.parent = this;
    }
    public BinaryTreeNode<T> getParent() {
        return this.parent;
    }
    public void removeLeft() {
        if(this.left!=null) {
            this.left.parent = null;
            this.left=null;
        }
    }
    public void removeRight() {
        if(this.right!=null) {
            this.right.parent = null;
            this.right=null;
        }
    }
    public BinaryTreeNode<T> getLeft()  {return this.left;}
    public BinaryTreeNode<T> getRight() {return this.right;}


    public String toString() {
    	String leftChild = this.left==null?"":this.left.toString();
    	String rightChild = this.right==null?"":this.right.toString();
    	return this.data.toString() + "\t(" + leftChild + ") ("+rightChild+")";
    }


    // other features ...

}