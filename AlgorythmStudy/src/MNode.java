
public class MNode<T> {
	MNode<T> left;
	MNode<T> right;
	T data;
	public MNode(MNode<T> left, MNode<T> right, T data) {
		// TODO Auto-generated constructor stub
		this.left = left;
		this.right = right;
		this.data = data;
	}
	
	public void setLeft(MNode<T> left) {
		this.left = left;
	}
	
	public void setRight(MNode<T> right) {
		this.right = right;
	}
	
	public void setData(T data) {
		this.data = data;
	}
}
