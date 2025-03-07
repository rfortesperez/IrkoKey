package com.example.irkokey.common.utils;

import androidx.recyclerview.widget.DiffUtil;
import com.example.irkokey.domain.models.Password;

/**
 * This class is used to compare two lists of Password objects and check if they are the same.
 * @param oldList The old list of Password objects.
 * @param newList The new list of Password objects.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/irkokey/common/utils/PasswordDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/example/irkokey/domain/models/Password;", "newList", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_debug"})
public final class PasswordDiffCallback extends androidx.recyclerview.widget.DiffUtil.Callback {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.irkokey.domain.models.Password> oldList = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.irkokey.domain.models.Password> newList = null;
    
    public PasswordDiffCallback(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.irkokey.domain.models.Password> oldList, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.irkokey.domain.models.Password> newList) {
        super();
    }
    
    /**
     * Returns the size of the old list.
     * @return The size of the old list.
     */
    @java.lang.Override
    public int getOldListSize() {
        return 0;
    }
    
    /**
     * Returns the size of the new list.
     * @return The size of the new list.
     */
    @java.lang.Override
    public int getNewListSize() {
        return 0;
    }
    
    /**
     * Checks if the items at the given positions in the old and new lists are the same.
     * @param oldItemPosition The position of the item in the old list.
     * @param newItemPosition The position of the item in the new list.
     * @return True if the items are the same, false otherwise.
     */
    @java.lang.Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }
    
    /**
     * Checks if the contents of the items at the given positions in the old and new lists are the same.
     * @param oldItemPosition The position of the item in the old list.
     * @param newItemPosition The position of the item in the new list.
     * @return True if the contents of the items are the same, false otherwise.
     */
    @java.lang.Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }
}