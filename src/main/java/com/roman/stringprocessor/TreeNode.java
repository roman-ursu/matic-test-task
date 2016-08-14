package com.roman.stringprocessor;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

	private String dictionaryItem;
	private int index;
	private List<TreeNode> children = new ArrayList<TreeNode>();
	private TreeNode parent;
	
	public TreeNode(int index, String dictionaryItem) {
		super();
		this.index = index;
		this.dictionaryItem = dictionaryItem;
	}

	public TreeNode() {
		super();
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public void addChild(int index, String dictiomaryItem) {
		TreeNode node = new TreeNode(index, dictiomaryItem);
		node.parent = this;
		children.add(node);
	}
	
	public void addChild(TreeNode treeNode) {
		treeNode.parent = this;
		children.add(treeNode);
	}
	
	public boolean isLeaf() {
		return children.size() == 0;
	}
	
	public String getDictionaryItem() {
		return dictionaryItem;
	}

	public void setDictionaryItem(String dictionaryItem) {
		this.dictionaryItem = dictionaryItem;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public TreeNode getParent() {
		return parent;
	}
	
	@Override
	public String toString() {
		if (parent != null) {
			return parent.toString() + " " + dictionaryItem;
		} else {
			return dictionaryItem;
		}
	}
}
