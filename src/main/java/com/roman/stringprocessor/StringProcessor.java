package com.roman.stringprocessor;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class StringProcessor {

	public List<String> findCombinations(String targetString, List<String> dictionary) {
		if (targetString == null || dictionary == null) {
			throw new NullPointerException("targetString or dictionary is null");
		}
		
		if(dictionary.size() == 0) {
			throw new IllegalArgumentException("Dictionary is empty");
		}
		
		TreeNode root = new TreeNode(0, "");
		buildTree(targetString, root, dictionary);
		
		List<String> combinations = new ArrayList<String>();
		
		traverse(targetString, root, combinations);
		return combinations;
	}
	
	private void buildTree(String targetString, TreeNode treeNode, List<String> dictionary) {
		int index = treeNode.getIndex();
		String subTargetString = targetString.substring(index);
		
		for (String dictionaryItem : dictionary) {
			if (StringUtils.startsWith(subTargetString, dictionaryItem)) {
				treeNode.addChild(index + dictionaryItem.length(), dictionaryItem);
			}
		}
		
		for (TreeNode treeNodeChild : treeNode.getChildren()) {
			if (treeNodeChild.getIndex() < targetString.length()) {
				buildTree(targetString, treeNodeChild, dictionary);
			}
		}
	}
	
	private void traverse(String targetString, TreeNode node, List<String> combinations) {
		if (node.isLeaf()) {
			String combination = node.toString();
			if (isValidCombimation(targetString, combination)) {
				combinations.add(combination);
			}
		}
		
		for (TreeNode child : node.getChildren()) {
			traverse(targetString, child, combinations);
		}
	}
	
	protected boolean isValidCombimation(String targetString, String rawCombination) {
		if (rawCombination != null && targetString != null) {
			String combitation = rawCombination.trim().replace(" ", "");
			return targetString.trim().equals(combitation);
		} else {
			return false;
		}
	}
}
