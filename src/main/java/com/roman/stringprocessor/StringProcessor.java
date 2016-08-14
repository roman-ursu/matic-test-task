package com.roman.stringprocessor;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class StringProcessor {

	public void start(String targetString, List<String> dictionary) {
		TreeNode root = new TreeNode(0, "");
		process(targetString, root, dictionary);
		
		traverse(root);
	}
	
	private void process(String targetString, TreeNode treeNode, List<String> dictionary) {
		int index = treeNode.getIndex();
		String subTargetString = targetString.substring(index);
		
		for (String dictionaryItem : dictionary) {
			if (StringUtils.startsWith(subTargetString, dictionaryItem)) {
				treeNode.addChild(index + dictionaryItem.length(), dictionaryItem);
			}
		}
		
		for (TreeNode treeNodeChild : treeNode.getChildren()) {
			if (treeNodeChild.getIndex() < targetString.length()) {
				process(targetString, treeNodeChild, dictionary);
			}
		}
	}
	
	private void traverse(TreeNode node) {
		if (node.isLeaf()) {
			System.out.println(node.toString());
		}
		
		for (TreeNode child : node.getChildren()) {
			traverse(child);
		}
	}
}
