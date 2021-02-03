package com.okmall.spring.component.message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author Kazuki Shimizu
 */
public class Messages implements Iterable<Messages.Message> {

	private final List<Message> values = new ArrayList<>();

	@Override
	public Iterator<Message> iterator() {
		return values.iterator();
	}

	@Override
	public void forEach(Consumer<? super Message> action) {
		values.forEach(action);
	}

	@Override
	public Spliterator<Message> spliterator() {
		return values.spliterator();
	}

	public Messages error(String message) {
		values.add(new Message("error", message));
		return this;
	}

	public Messages success(String message) {
		values.add(new Message("success", message));
		return this;
	}

	public Messages info(String message) {
		values.add(new Message("info", message));
		return this;
	}

	public Messages warn(String message) {
		values.add(new Message("warn", message));
		return this;
	}

	public static class Message {
		private final String type;
		private final String text;
		private Message(String type, String text) {
			this.type = type;
			this.text = text;
		}

		public String getType() {
			return type;
		}

		public String getText() {
			return text;
		}
	}
}
