/*
 * Copyright 2000-2014 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.event;

import java.io.Serializable;
import java.util.List;

import com.vaadin.data.sort.SortOrder;
import com.vaadin.shared.ui.grid.SortEventOriginator;
import com.vaadin.ui.Component;

/**
 * Event describing a change in sorting of a {@link Container}. Fired by
 * {@link SortOrderChangeNotifier SortOrderChangeNotifiers}.
 * 
 * @see SortOrderChangeListener
 * 
 * @since
 * @author Vaadin Ltd
 */
public class SortOrderChangeEvent extends Component.Event {

    private final List<SortOrder> sortOrder;
    private final SortEventOriginator originator;

    /**
     * Creates a new sort order change event with a sort order list.
     * 
     * @param source
     *            the component from which the event originates
     * @param sortOrder
     *            the new sort order list
     * @param originator
     *            an enumeration describing what triggered the sorting
     */
    public SortOrderChangeEvent(Component source, List<SortOrder> sortOrder,
            SortEventOriginator originator) {
        super(source);
        this.sortOrder = sortOrder;
        this.originator = originator;
    }

    /**
     * Gets the sort order list.
     * 
     * @return the sort order list
     */
    public List<SortOrder> getSortOrder() {
        return sortOrder;
    }

    /**
     * Returns whether this event originated from actions done by the user.
     * 
     * @return true if sort event originated from user interaction
     */
    public boolean isUserOriginated() {
        return originator == SortEventOriginator.USER;
    }

    /**
     * Listener for sort order change events.
     */
    public interface SortOrderChangeListener extends Serializable {
        /**
         * Called when the sort order has changed.
         * 
         * @param event
         *            the sort order change event
         */
        public void sortOrderChange(SortOrderChangeEvent event);
    }

    /**
     * The interface for adding and removing listeners for
     * {@link SortOrderChangeEvent SortOrderChangeEvents}.
     */
    public interface SortOrderChangeNotifier extends Serializable {
        /**
         * Adds a sort order change listener that gets notified when the sort
         * order changes.
         * 
         * @param listener
         *            the sort order change listener to add
         */
        public void addSortOrderChangeListener(SortOrderChangeListener listener);

        /**
         * Removes a sort order change listener previously added using
         * {@link #addSortOrderChangeListener(SortOrderChangeListener)}.
         * 
         * @param listener
         *            the sort order change listener to remove
         */
        public void removeSortOrderChangeListener(
                SortOrderChangeListener listener);
    }
}