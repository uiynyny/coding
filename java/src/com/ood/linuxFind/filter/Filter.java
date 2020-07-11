package com.ood.linuxFind.filter;

import com.ood.linuxFind.File;

public abstract class Filter {
    public abstract boolean apply(File file);
}
