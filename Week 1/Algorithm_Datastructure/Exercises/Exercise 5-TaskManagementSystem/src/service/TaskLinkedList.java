package service;

import model.Task;

public class TaskLinkedList {

    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public Task searchTask(int id) {
        Node temp = head;

        while (temp != null) {
            if (temp.task.getTaskId() == id) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    public void displayTasks() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    public void deleteTask(int id) {

        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head.task.getTaskId() == id) {
            head = head.next;
            System.out.println("Task deleted!");
            return;
        }

        Node temp = head;

        while (temp.next != null &&
                temp.next.task.getTaskId() != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task not found!");
            return;
        }

        temp.next = temp.next.next;
        System.out.println("Task deleted!");
    }
}